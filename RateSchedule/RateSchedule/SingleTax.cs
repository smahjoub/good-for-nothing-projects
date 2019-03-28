using System;
using System.Collections.Generic;
using System.Text;

namespace RateSchedule
{
    public sealed class SingleTax : Tax
    {
        private const decimal RANGE_1_MIN = decimal.Zero;
        private const decimal RANGE_1_MAX = 9075M;
        private const decimal RANGE_1_TAX_PERENTAGE = 10.0M;
        private const decimal RANGE_1_MAX_TAX = 907.5M;

        private const decimal RANGE_2_MAX = 36900M;
        private const decimal RANGE_2_TAX_PERENTAGE = 15.0M;
        private const decimal RANGE_2_MAX_TAX = 5081.25M;

        private const decimal RANGE_3_MAX = 89350M;
        private const decimal RANGE_3_TAX_PERENTAGE = 25.0M;
        private const decimal RANGE_3_MAX_TAX = 18193.75M;

        private const decimal RANGE_4_MAX = 186350M;
        private const decimal RANGE_4_TAX_PERENTAGE = 28.0M;
        private const decimal RANGE_4_MAX_TAX = 45353.75M;

        private const decimal RANGE_5_MAX = 405100M;
        private const decimal RANGE_5_TAX_PERENTAGE = 33.0M;
        private const decimal RANGE_5_MAX_TAX = 117541.25M;


        private const decimal RANGE_6_MAX = 406750M;
        private const decimal RANGE_6_TAX_PERENTAGE = 35.0M;
        private const decimal RANGE_6_MAX_TAX = 118118.75M;

        private const decimal RANGE_7_MAX = decimal.MaxValue;
        private const decimal RANGE_7_TAX_PERENTAGE = 39.6M;
       

        public SingleTax()
        {
            ranges = new List<TaxRange>();
            ranges.Add(new TaxRange(RANGE_1_MIN, RANGE_1_MAX, RANGE_1_TAX_PERENTAGE, decimal.Zero));
            ranges.Add(new TaxRange(RANGE_1_MAX, RANGE_2_MAX, RANGE_2_TAX_PERENTAGE, RANGE_1_MAX_TAX));
            ranges.Add(new TaxRange(RANGE_2_MAX, RANGE_3_MAX, RANGE_3_TAX_PERENTAGE, RANGE_2_MAX_TAX));
            ranges.Add(new TaxRange(RANGE_3_MAX, RANGE_4_MAX, RANGE_4_TAX_PERENTAGE, RANGE_3_MAX_TAX));
            ranges.Add(new TaxRange(RANGE_4_MAX, RANGE_5_MAX, RANGE_5_TAX_PERENTAGE, RANGE_4_MAX_TAX));
            ranges.Add(new TaxRange(RANGE_5_MAX, RANGE_6_MAX, RANGE_6_TAX_PERENTAGE, RANGE_5_MAX_TAX));
            ranges.Add(new TaxRange(RANGE_6_MAX, RANGE_7_MAX, RANGE_7_TAX_PERENTAGE, RANGE_6_MAX_TAX));
        }
    }
}
