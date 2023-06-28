namespace Game
{
    public class Hedgehog : Animal
    {
        public override KindOfSpecies Species => KindOfSpecies.EarthWorm;

        public override string ImageName => "hedgehog";

        public override string ToString()
        {
            return "Hedgehog";
        }
    }
}
