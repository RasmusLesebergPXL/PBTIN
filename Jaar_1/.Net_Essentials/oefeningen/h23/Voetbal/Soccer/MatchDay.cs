using System;
using System.Collections.Generic;

namespace Soccer
{
    public class MatchDay
    {
        public MatchDay(int day, List<Team> teamsOne, List<Team> teamsTwo, DateTime date)
        {
            DayNumber = day;
            TeamsList1 = teamsOne;
            TeamsList2 = teamsTwo;
            Date = date;
        }
        public int DayNumber { get; set; }

        public List<Team> TeamsList1 { get; set; }

        public List<Team> TeamsList2 { get; set; }

        public List<int> ScoresList1 { get; set; }

        public List<int> ScoresList2 { get; set; }

        public DateTime Date { get; set; }

        public override string ToString()
        {
            return $"Matchday {DayNumber}: {Date.ToString("dd/MM/yyyy")}";
        }
    }
}
