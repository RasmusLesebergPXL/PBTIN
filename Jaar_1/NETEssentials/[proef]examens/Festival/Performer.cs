using System;
using System.Collections.Generic;

namespace Festival
{
    public abstract class Performer
    {
        public string Name { get; set; }

        public int ReservationNumber { get; set; }

        public TimeSpan StartTime { get; set; }

        public TimeSpan EndTime { get; set; }

        public int[]? TechnicalSupplies { get; set; }

        public IList<string>? Rider { get; set; }

        public override string ToString()
        {
            return $"{StartTime.ToString()}-{EndTime.ToString()} {Name}";
        }


    }
}
