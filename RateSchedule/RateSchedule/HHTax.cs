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

        private const decimal RANGE_7_TAX_PERENTAGE = 39.6M;


        public HHTax()
        {
            range1Min = RANGE_1_MIN;
            range1Max = RANGE_1_MAX;
            range1TaxPercentage = RANGE_1_TAX_PERENTAGE;
            range1MaxTax = RANGE_1_MAX_TAX;

            range2Max = RANGE_2_MAX;
            range2TaxPercentage = RANGE_2_TAX_PERENTAGE;
            range2MaxTax = RANGE_2_MAX_TAX;

            range3Max = RANGE_3_MAX;
            range3TaxPercentage = RANGE_3_TAX_PERENTAGE;
            range3MaxTax = RANGE_3_MAX_TAX;

            range4Max = RANGE_4_MAX;
            range4TaxPercentage = RANGE_4_TAX_PERENTAGE;
            range4MaxTax = RANGE_4_MAX_TAX;

            range5Max = RANGE_5_MAX;
            range5TaxPercentage = RANGE_5_TAX_PERENTAGE;
            range5MaxTax = RANGE_5_MAX_TAX;

            range6Max = RANGE_6_MAX;
            range6MaxPercentage = RANGE_6_TAX_PERENTAGE;
            range6MaxTax = RANGE_6_MAX_TAX;

            range7TaxPercentage = RANGE_7_TAX_PERENTAGE;
        }
    }
}