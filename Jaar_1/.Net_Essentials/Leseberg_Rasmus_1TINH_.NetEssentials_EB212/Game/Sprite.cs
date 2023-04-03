using System;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Game
{
    public abstract class Sprite
    {
        protected Sprite()
        {
            BitmapImage demoBitmapImage = new BitmapImage();
            demoBitmapImage.BeginInit();
            demoBitmapImage.UriSource = new Uri($"images\\{ImageName}.png", UriKind.RelativeOrAbsolute);
            demoBitmapImage.EndInit();
            Image = new Image
            {
                Source = demoBitmapImage
            };
        }

        public Image Image { get; set;}
        public int X { get; set; } // X columnumber 
        // for the example on p 5 (see text) fifth column => X = 4
        public int Y { get; set; } // Y rownumber
        // for the example on p 5 (see text) 7th row => Y = 6
        public abstract void AdjustSize(double width, double height);
        public abstract string ImageName { get; }
    }
}
