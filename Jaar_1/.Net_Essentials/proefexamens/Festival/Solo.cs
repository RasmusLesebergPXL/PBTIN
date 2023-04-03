using System;
using System.Collections.Generic;

namespace Festival
{
    public class Solo : Performer
    {
        public Solo(string name, int reservation, string startTime, string endTime,
                    int[] supplies, IList<string> rider, string type)
        {
            Name = name;
            ReservationNumber = reservation;
            StartTime = TimeSpan.Parse(startTime);
            EndTime = TimeSpan.Parse(endTime);
            TechnicalSupplies = supplies;
            Rider = rider;
            Type = type;
        }

        public string Type { get; set; }
    }
}
