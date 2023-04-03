using DartApp.AppLogic.Contracts;
using DartApp.Domain;
using DartApp.Domain.Contracts;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;

namespace DartApp.Infrastructure.Storage
{
    internal class PlayerFileRepository : IPlayerRepository
    {
        private readonly string _playerFileDirectory;

        public PlayerFileRepository(string playerFileDirectory)
        {
            Directory.CreateDirectory(playerFileDirectory);
            _playerFileDirectory = playerFileDirectory;
        }

        public void Add(IPlayer player)
        {
            SavePlayer(player);
        }

        public IReadOnlyList<IPlayer> GetAll()
        {
            List<IPlayer> list = new();
            var filePaths = Directory.GetFiles(_playerFileDirectory);

            foreach (string fileName in filePaths)
            {
                string json = File.ReadAllText(fileName);
                list.Add(ReadPlayerFromFile(json));
            }
            return list.AsReadOnly();
        }

        public void SaveChanges(IPlayer player)
        {
            SavePlayer(player);
        }


        private IPlayer ReadPlayerFromFile(string playerFilePath)
        {
            return ConvertJsonToPlayer(playerFilePath);
        }

        private void SavePlayer(IPlayer player)
        {
            string myFile = GetPlayerFilePath(player.Id);
            string json = ConvertPlayerToJson(player);
            StreamWriter writer = new StreamWriter(myFile);

            writer.WriteLine(json);
            writer.Close();
        }

        private string ConvertPlayerToJson(IPlayer player)
        {
            string json = JsonConvert.SerializeObject(player, new JsonSerializerSettings
            {
                TypeNameHandling = TypeNameHandling.Auto
            });
            return json;
        }

        private IPlayer ConvertJsonToPlayer(string json)
        {
            return JsonConvert.DeserializeObject<Player>(json, new JsonSerializerSettings
            {
                ContractResolver = new JsonAllowPrivateSetterContractResolver(),
                ConstructorHandling = ConstructorHandling.AllowNonPublicDefaultConstructor,
                TypeNameHandling = TypeNameHandling.Auto
            }) as IPlayer;
        }

        private string GetPlayerFilePath(Guid playerId)
        {
            string fileName = $"Player_{playerId}.json";
            return Path.Combine(_playerFileDirectory, fileName);
        }
    }
}
