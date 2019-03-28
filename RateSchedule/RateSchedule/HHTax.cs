using System;
using System.Collections.Generic;
using System.Text;

namespace RateSchedule
{
    public sealed class HHTax : Tax
    {
        private const decimal RANGE_1_MIN = decimal.Zero;
        private const decimal RANGE_1_MAX = 12950M;
        private const decimal RANGE_1_TAX_PERENTAGE = 10.0M;
        private const decimal RANGE_1_MAX_TAX = 1295M;

        private const decimal RANGE_2_MAX = 49400M;
        private const decimal RANGE_2_TAX_PERENTAGE = 15.0M;
        private const decimal RANGE_2_MAX_TAX = 6762.50M;

        private const decimal RANGE_3_MAX = 127550M;
        private const decimal RANGE_3_TAX_PERENTAGE = 25.0M;
        private const decimal RANGE_3_MAX_TAX = 26300M;

        private const decimal RANGE_4_MAX = 206600M;
        private const decimal RANGE_4_TAX_PERENTAGE = 28.0M;
        private const decimal RANGE_4_MAX_TAX = 48434M;

        private const decimal RANGE_5_MAX = 405100M;
        private const decimal RANGE_5_TAX_PERENTAGE = 33.0M;
        private const decimal RANGE_5_MAX_TAX = 113939M;


        private const decimal RANGE_6_MAX = 432200M;
        private const decimal RANGE_6_TAX_PERENTAGE = 35.0M;
        private const decimal RANGE_6_MAX_TAX = 123424M;

        private const decimal RANGE_7_MAX = decimal.MaxValue;
        private const decimal RANGE_7_TAX_PERENTAGE = 39.6M;


        public HHTax()
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