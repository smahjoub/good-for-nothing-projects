using System;
using System.Collections.Generic;
using System.Text;
using RateSchedule.Extentions;

namespace RateSchedule
{
    public abstract class Tax
    {
        protected decimal range1Min;
        protected decimal range1Max;
        protected decimal range1TaxPercentage;
        protected decimal range1MaxTax;

        protected decimal range2Max;
        protected decimal range2TaxPercentage;
        protected decimal range2MaxTax;

        protected decimal range3Max;
        protected decimal range3TaxPercentage;
        protected decimal range3MaxTax;

        protected decimal range4Max;
        protected decimal range4TaxPercentage;
        protected decimal range4MaxTax;

        protected decimal range5Max;
        protected decimal range5TaxPercentage;
        protected decimal range5MaxTax;

        protected decimal range6Max;
        protected decimal range6MaxPercentage;
        protected decimal range6MaxTax;

        protected decimal range7TaxPercentage;


        public decimal Calculate(decimal income)
        {
            if(decimal.Compare(income, range1Min) <= 0)
            {
                return decimal.Zero;
            }
            else if (decimal.Compare(income, range1Min) > 0 && decimal.Compare(income, range1Max) <= 0)
            {
                return income.GetPercentage(range1TaxPercentage);
            }
            else if (decimal.Compare(income, range1Max) > 0 && decimal.Compare(income, range2Max) <= 0)
            {
                return decimal.Add(range1MaxTax, decimal.Subtract(income, range1Max).GetPercentage(range2TaxPercentage));
            }
            else if (decimal.Compare(income, range2Max) > 0 && decimal.Compare(income, range3Max) <= 0)
            {
                return decimal.Add(range2MaxTax, decimal.Subtract(income, range2Max).GetPercentage(range3TaxPercentage));
            }
            else if (decimal.Compare(income, range3Max) > 0 && decimal.Compare(income, range4Max) <= 0)
            {
                return decimal.Add(range3MaxTax, decimal.Subtract(income, range3Max).GetPercentage(range4TaxPercentage));
            }
            else if (decimal.Compare(income, range4Max) > 0 && decimal.Compare(income, range5Max) <= 0)
            {
                return decimal.Add(range4MaxTax, decimal.Subtract(income, range4Max).GetPercentage(range5TaxPercentage));
            }
            else if (decimal.Compare(income, range5Max) > 0 && decimal.Compare(income, range6Max) <= 0)
            {
                return decimal.Add(range5MaxTax, decimal.Subtract(income, range5Max).GetPercentage(range6MaxPercentage));
            }
            else
            {
                return decimal.Add(range6MaxTax, decimal.Subtract(income, range6Max).GetPercentage(range7TaxPercentage));
            }
        }

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
    }
}
