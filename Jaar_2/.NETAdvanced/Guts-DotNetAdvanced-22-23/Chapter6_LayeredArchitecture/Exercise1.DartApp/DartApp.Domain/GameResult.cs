using DartApp.Domain.Contracts;
using System;

namespace DartApp.Domain
{
    public class GameResult : IGameResult
    {
        private GameResult() { }

        public GameResult(Guid playerId, int numberOf180, double averageThrow, int bestThrow)
        {
            if (numberOf180 < 0 || averageThrow < 0 || bestThrow < 0 ||
                averageThrow > bestThrow || bestThrow > 180)
            {
                throw new ArgumentException();
            }
            else if (numberOf180 >= 1 && bestThrow != 180)
            {
                throw new ArgumentException();
            }
            NumberOf180 = numberOf180;
            AverageThrow = averageThrow;
            BestThrow = bestThrow;
            PlayerId = playerId;
            Id = Guid.NewGuid();
        }
        public Guid Id { get; private set; }

        public Guid PlayerId { get; private set; }

        public int NumberOf180 { get; private set; }

        public double AverageThrow { get; private set; }

        public int BestThrow { get; private set; }

        public override string ToString()
        {
            return $"Average: {AverageThrow:00.00}; 180s: {NumberOf180}; Best: {BestThrow}";
        }
    }
}
