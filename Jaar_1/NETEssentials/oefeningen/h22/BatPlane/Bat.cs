using System;
using System.Media;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace ExampleInterface
{
    public class Bat : IFlying, IAnimal
    {
        private Image _batImage;
        private SoundPlayer _batSound;

        int IFlying.Mps => 15;

        public Bat()
        {
            _batSound = new SoundPlayer(@"..\..\..\bats.wav");
        }
        
        public void DisplayOn(Canvas canvas)
        {
            _batImage = new Image
            {
                Source = new BitmapImage(new Uri(@"bat.png", UriKind.RelativeOrAbsolute)),
                Margin = new Thickness(200, 150, 0, 0),
                Width = 150,
                Height = 150
            };
            canvas.Children.Add(_batImage);
        }

        public void Fly()
        {
            _batImage.Margin = new Thickness(200, 15, 0, 0);
        }

        public void Land()
        {
            _batImage.Margin = new Thickness(200, 150, 0, 0);
        }

        public void MakeSound()
        {
            _batSound.Play();
        }
    }
}
