namespace Soccer
{
    public enum PlayerFunction
    {
        Goalkeeper = 'G',
        Defender = 'D',
        Midfielder = 'M',
        Forward = 'F'
    }

    public class Player
    {
        public Player(string name, string firstName, string number, PlayerFunction function)
        {
            Name = name;
            FirstName = firstName;
            ShirtNumber = number;
            Function = function;
        }

        public string Name { get; set; }

        public string FirstName { get; set; }

        public string ShirtNumber { get; set; }

        public PlayerFunction Function { get; set; }
    }
}
