using System;
using System.Collections.Generic;
using System.Text;

namespace RateSchedule.Ranges
{
    public interface IRangeInfo
    {
        int RangesCount { get; }

        decimal[,] Ranges { get; }
    }
}
