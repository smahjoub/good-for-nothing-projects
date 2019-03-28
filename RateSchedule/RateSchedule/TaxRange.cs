using System;
using System.Collections.Generic;
using System.Text;
using RateSchedule.Extentions;

namespace RateSchedule
{
    public sealed class TaxRange
    {
        #region private fields
        private readonly decimal rangeMin;
        private readonly decimal rangeMax;
        private readonly decimal rangeTaxPercentage;
        private readonly decimal previousRangeTaxMaximum;
        #endregion


        #region ctor
        public TaxRange(decimal min, decimal max, decimal percentage, decimal prevRangeTaxMaximum)
        {
            rangeMin = min;
            rangeMax = max;
            rangeTaxPercentage = percentage;
            previousRangeTaxMaximum = prevRangeTaxMaximum;
        }
        #endregion


        #region methods
        public bool IsInRange(decimal income)
        {
            return decimal.Compare(income, rangeMin) > 0 && decimal.Compare(income, rangeMax) <= 0;
        }

        public decimal CalculateTax(decimal income)
        {
            return decimal.Add(previousRangeTaxMaximum, decimal.Subtract(income, rangeMin).GetPercentage(rangeTaxPercentage));
        }
        #endregion

        #region properties

        public decimal RangeMin
        {
            get { return rangeMin; }
        }

        public decimal RangeMax
        {
            get { return rangeMax; }
        }

        public decimal RangeTaxPercentage
        {
            get { return rangeTaxPercentage; }
        }

        public decimal PreviousRangeTaxMaximum
        {
            get { return previousRangeTaxMaximum; }
        }

        #endregion
    }
}
