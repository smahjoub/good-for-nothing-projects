using System;
using System.Collections.Generic;
using System.Text;
using RateSchedule.Extentions;

namespace RateSchedule
{
    public abstract class Tax
    {
        #region fields
        protected List<TaxRange> ranges;
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

        #region static methods
        public static Tax GenerateInstanceFromSituation(TaxSituation taxSituation)
        {
            Tax instance = null;

            switch (taxSituation)
            {
                case TaxSituation.Single:
                    instance = new SingleTax();
                    break;
                case TaxSituation.MarriedfilingJointlyorQualifyingWidow:
                    instance = new MFJOrQWTax();
                    break;
                case TaxSituation.MarriedFilingSeparately:
                    instance = new MFSTax();
                    break;
                case TaxSituation.HeadofHousehold:
                    instance = new HHTax();
                    break;
            }

            return instance;

        }
        #endregion

    }
}
