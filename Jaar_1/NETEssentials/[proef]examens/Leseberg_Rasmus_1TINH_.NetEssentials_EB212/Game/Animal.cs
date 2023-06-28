namespace Game
{
    public abstract class Animal : Sprite
    {
        public abstract KindOfSpecies Species { get; }

        public override void AdjustSize(double width, double height)
        {
            Image.Width = width;
            Image.Height = height;
        }
    }
}

