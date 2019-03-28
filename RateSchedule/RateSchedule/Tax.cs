using System;
using System.Collections.Generic;
using System.Text;
using RateSchedule.Extentions;
using RateSchedule.Ranges;

namespace RateSchedule
{
    public sealed class Tax
    {
        #region fields
        private readonly List<TaxRange> ranges;
        private readonly TaxSituation taxSituation;
        #endregion

        #region ctor
        public Tax(IRangeInfo rangeInfo, TaxSituation taxSitu)
        {
            ranges = new List<TaxRange>();
            var rangesInfo = rangeInfo.Ranges;
            for (int i = 0; i < rangeInfo.RangesCount; i++)
            {
                ranges.Add(new TaxRange(rangesInfo[i, 0], rangesInfo[i, 1], rangesInfo[i, 2], rangesInfo[i, 3]));
            }

            taxSituation = taxSitu;
        }
        #endregion

        #region public methods
        public decimal Calculate(decimal income)
        {
            if (decimal.Compare(income, decimal.Zero) <= 0)
            {
                return decimal.Zero;
            }

            foreach (var range in ranges)
            {
                if (range.IsInRange(income))
                {
                    return range.CalculateTax(income);
                }

            }

            throw new Exception("Could not find suitable range for this income.");
        }
        #endregion


        #region propeties
        public IList<TaxRange> Ranges
        {
            get { return ranges.AsReadOnly(); }
        }

        public TaxSituation TaxSituation
        {
            get { return taxSituation; }
        }
        #endregion

        #region static methods
        public static Tax GenerateInstanceFromSituation(TaxSituation taxSituation)
        {
            Tax instance = null;

            switch (taxSituation)
            {
                case TaxSituation.Single:
                    instance = new Tax(new SingleTax(), taxSituation);
                    break;
                case TaxSituation.MarriedfilingJointlyorQualifyingWidow:
                    instance = new Tax(new MFJOrQWTax(), taxSituation);
                    break;
                case TaxSituation.MarriedFilingSeparately:
                    instance = new Tax(new MFSTax(), taxSituation);
                    break;
                case TaxSituation.HeadofHousehold:
                    instance = new Tax(new HHTax(), taxSituation);
                    break;
            }

            return instance;

        }
        #endregion

    }
}
