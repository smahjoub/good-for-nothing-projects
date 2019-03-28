using System;
using System.Collections.Generic;
using System.Text;

namespace RateSchedule.Ranges
{
    public sealed class SingleTax : IRangeInfo
    {
        private const int RANGES_COUNT = 7;

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


        public decimal[,] Ranges
        {
            get
            {
                decimal[,] returnValue = new decimal[7, 4];

                returnValue[0, 0] = RANGE_1_MIN; returnValue[0, 1] = RANGE_1_MAX; returnValue[0, 2] = RANGE_1_TAX_PERENTAGE; returnValue[0, 3] = 0;
                returnValue[1, 0] = RANGE_1_MAX; returnValue[1, 1] = RANGE_2_MAX; returnValue[1, 2] = RANGE_2_TAX_PERENTAGE; returnValue[1, 3] = RANGE_1_MAX_TAX;
                returnValue[2, 0] = RANGE_2_MAX; returnValue[2, 1] = RANGE_3_MAX; returnValue[2, 2] = RANGE_3_TAX_PERENTAGE; returnValue[2, 3] = RANGE_2_MAX_TAX;
                returnValue[3, 0] = RANGE_3_MAX; returnValue[3, 1] = RANGE_4_MAX; returnValue[3, 2] = RANGE_4_TAX_PERENTAGE; returnValue[3, 3] = RANGE_3_MAX_TAX;
                returnValue[4, 0] = RANGE_4_MAX; returnValue[4, 1] = RANGE_5_MAX; returnValue[4, 2] = RANGE_5_TAX_PERENTAGE; returnValue[4, 3] = RANGE_4_MAX_TAX;
                returnValue[5, 0] = RANGE_5_MAX; returnValue[5, 1] = RANGE_6_MAX; returnValue[5, 2] = RANGE_6_TAX_PERENTAGE; returnValue[5, 3] = RANGE_5_MAX_TAX;
                returnValue[6, 0] = RANGE_6_MAX; returnValue[6, 1] = RANGE_7_MAX; returnValue[6, 2] = RANGE_7_TAX_PERENTAGE; returnValue[6, 3] = RANGE_6_MAX_TAX;

                return returnValue;
            }
        }

        public int RangesCount
        {
            get { return RANGES_COUNT; }
        }
    }
}
