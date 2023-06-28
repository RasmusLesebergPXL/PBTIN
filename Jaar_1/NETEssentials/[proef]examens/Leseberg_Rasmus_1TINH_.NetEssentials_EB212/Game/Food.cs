using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Game
{
    public class Food : Sprite
    {
        public Food(KindOfSpecies species)
        {
            Species = species;
            Image = new Image
            {
                Source = new BitmapImage(new Uri(@"images\" + ImageName + ".png", UriKind.Relative)),
            };
        }

        public KindOfSpecies Species { get; }

        public override string ImageName => Species.ToString().ToLower();


        public override void AdjustSize(double width, double height)
        {
            Image.Width = width / 3;
            Image.Height = height / 3;
            Image.Margin = new Thickness(width / 3, height / 3, 0, 0);
        }
    }
}
