using DartApp.Domain.Contracts;

namespace DartApp.AppLogic
{
    internal class PlayerStats : IPlayerStats
    {
        public PlayerStats(int numberOf180, double averageThrow, int bestThrow, double averageBestThrow)
        {
            Total180 = numberOf180;
            AverageThrow = averageThrow;
            BestThrow = bestThrow;
            AverageBestThrow = averageBestThrow;
        }
        public double AverageThrow { get; set; }

        public int Total180 { get; set; }

        public int BestThrow { get; set; }

        public double AverageBestThrow { get; set; }

        public override string ToString()
        {
            return $"Average: {AverageThrow:00.00}; 180s: {Total180}; Best throw: {BestThrow} (Average best throw: {AverageBestThrow:00.00})";
        }
    }
}
