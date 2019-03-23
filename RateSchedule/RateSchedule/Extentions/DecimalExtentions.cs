using System;
using System.Collections.Generic;
using System.Text;

namespace RateSchedule.Extentions
{
    internal static class DecimalExtentions
    {
        internal static decimal GetPercentage(this decimal dec, decimal percentage)
        {
            return decimal.Multiply(decimal.Divide(dec,100.0M), percentage);
        }
    }
}
