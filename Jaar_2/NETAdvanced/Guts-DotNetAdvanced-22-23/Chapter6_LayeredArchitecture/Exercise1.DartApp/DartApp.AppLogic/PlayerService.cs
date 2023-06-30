using DartApp.AppLogic.Contracts;
using DartApp.Domain;
using DartApp.Domain.Contracts;
using System.Collections.Generic;
using System.Net.NetworkInformation;

namespace DartApp.AppLogic
{
    internal class PlayerService : IPlayerService
    {
        private IPlayerRepository _playerRepository;
        public PlayerService(IPlayerRepository repository)
        {
            _playerRepository = repository;
        }

        public void AddGameResultForPlayer(IPlayer player, int number180, double average, int bestThrow)
        {
            GameResult gameResult = new(player.Id, number180, average, bestThrow);
            player.AddGameResult(gameResult);
            _playerRepository.SaveChanges(player);
        }

        public IPlayer AddPlayer(string playerName)
        {
            Player player = new Player(playerName);
            _playerRepository.Add(player);
            _playerRepository.SaveChanges(player);
            return player;
        }

        public IReadOnlyList<IPlayer> GetAllPlayers()
        {
            return _playerRepository.GetAll();
        }

        public IPlayerStats GetStatsForPlayer(IPlayer player)
        {
            return player.GetPlayerStats();
        }
    }
}
