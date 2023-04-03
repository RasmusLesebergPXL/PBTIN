namespace Game
{
    public class Squirrel : Animal
    {
        public override KindOfSpecies Species => KindOfSpecies.Acorn;

        public override string ImageName => "squirrel";

        public override string ToString()
        {
            return "Squirrel";
        }
    }
}
