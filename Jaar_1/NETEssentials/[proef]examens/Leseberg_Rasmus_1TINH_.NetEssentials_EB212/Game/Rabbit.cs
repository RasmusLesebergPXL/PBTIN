namespace Game
{
    public class Rabbit : Animal
    {
        public override KindOfSpecies Species => KindOfSpecies.Carrot;

        public override string ImageName => "rabbit";

        public override string ToString()
        {
            return "Rabbit";
        }
    }
}
