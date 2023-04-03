using System.Collections.Generic;

namespace Soccer
{
    public class Team
    {
        public Team(string id, string name, List<Player> players)
        {
            Id = id;
            Name = name;
            Players = players;
        }

        public string Id { get; set; }

        public string Name { get; set; }

        public int Points { get; set; }

        public List<Player> Players { get; set; }

    }
}
