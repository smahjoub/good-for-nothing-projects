using RateSchedule.Ranges;
using System;
using Xunit;

namespace RateSchedule.Tests
{
    public class TaxTests
    {
        [Theory]
        [InlineData(0, 0d)]
        [InlineData(8000, 800d)]
        [InlineData(20000, 2546.25d)]
        [InlineData(40000, 5856.25d)]
        [InlineData(90000, 18375.75d)]
        [InlineData(400200, 115924.25d)]
        [InlineData(405200, 117576.25d)]
        [InlineData(408200, 118692.95d)]
        [InlineData(2989900, 1141046.15d)]
        public void SingleTaxesTest(decimal amount, decimal expectedTaxes)
        {
            Tax tax = new Tax(new SingleTax(), TaxSituation.Single);

            decimal t = tax.Calculate(amount);

            Assert.True(decimal.Compare(t, expectedTaxes) == 0);
        }

        [Theory]
        [InlineData(0, 0d)]
        [InlineData(8000, 800d)]
        [InlineData(20000, 2352.50d)]
        [InlineData(127550,26300d)]
        [InlineData(200000, 46586d)]
        [InlineData(400000, 112256d)]
        [InlineData(420000, 119154d)]
        [InlineData(500000, 150272.80d)]
        public void HHTaxesTest(decimal amount, decimal expectedTaxes)
        {
            Tax tax = new Tax(new HHTax(), TaxSituation.HeadofHousehold);

            decimal t = tax.Calculate(amount);

            Assert.True(decimal.Compare(t, expectedTaxes) == 0);
        }

        [Theory]
        [InlineData(0, 0d)]
        [InlineData(8000, 800d)]
        [InlineData(70000, 9592.5d)]
        [InlineData(140000, 26712.5d)]
        [InlineData(220000, 48847d)]
        [InlineData(400000, 107904.5d)]
        [InlineData(450000, 125302.5d)]
        [InlineData(500000, 144752.9d)]
        public void MFJOrQWTaxTest(decimal amount, decimal expectedTaxes)
        {
            Tax tax = new Tax(new MFJOrQWTax(), TaxSituation.MarriedfilingJointlyorQualifyingWidow);

            decimal t = tax.Calculate(amount);

            Assert.True(decimal.Compare(t, expectedTaxes) == 0);
        }

        [Theory]
        [InlineData(0, 0d)]
        [InlineData(8000, 800d)]
        [InlineData(35000, 4796.25d)]
        [InlineData(70000, 13356.25d)]
        [InlineData(110000, 24423.5d)]
        [InlineData(200000, 53952.25d)]
        [InlineData(225000, 62651.25d)]
        [InlineData(500000, 171376.45d)]
        public void MFSTaxTest(decimal amount, decimal expectedTaxes)
        {
            Tax tax = new Tax(new MFSTax(), TaxSituation.MarriedFilingSeparately);

            decimal t = tax.Calculate(amount);

            Assert.True(decimal.Compare(t, expectedTaxes) == 0);
        }
    }
}
