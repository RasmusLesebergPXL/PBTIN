using System;
using System.Collections.Generic;

namespace Festival
{
    public class Band : Performer
    {
        public Band(string name, int reservation, string startTime, string endTime, 
                    int[] supplies, IList<string> rider, int members) 
        {
            Name = name;
            ReservationNumber = reservation;
            StartTime = TimeSpan.Parse(startTime);
            EndTime = TimeSpan.Parse(endTime);
            TechnicalSupplies = supplies;
            Rider = rider;
            MemberCount = members;
        }

        public int MemberCount { get; set; }
    }
}
