using DartApp.AppLogic;
using DartApp.Domain.Contracts;
using System;
using System.Collections.Generic;

namespace DartApp.Domain
{
    public class Player : IPlayer
    {
        private List<IGameResult> _results = new List<IGameResult>();
        private Player() { }

        public Player(string name)
        {
            if (name is null || name == "")
            {
                throw new ArgumentException();
            }
            Name = name;
            Id = Guid.NewGuid();
        }
        public Guid Id { get; private set; }

        public string Name { get; private set; }

        public IReadOnlyCollection<IGameResult> GameResults => _results;

        public void AddGameResult(IGameResult gameResult)
        {
            _results.Add(gameResult);
        }

        public IPlayerStats GetPlayerStats()
        {
            int numberOf180s = 0;
            int bestThrow = 0;
            double average = 0;
            double averageBestThrow = 0;

            if (GameResults.Count == 0)
            {
                return new PlayerStats(0, 0, 0, 0);
            }
            else
            {
                foreach (IGameResult result in GameResults)
                {
                    if (result.NumberOf180 > numberOf180s)
                    {
                        numberOf180s = result.NumberOf180;
                    }
                    if (result.BestThrow > bestThrow)
                    {
                        bestThrow = result.BestThrow;
                    }
                    average += result.AverageThrow;
                    averageBestThrow += result.BestThrow;
                }

                return new PlayerStats(numberOf180s, average / GameResults.Count, bestThrow,
                                        averageBestThrow / GameResults.Count) as IPlayerStats;
            }
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
