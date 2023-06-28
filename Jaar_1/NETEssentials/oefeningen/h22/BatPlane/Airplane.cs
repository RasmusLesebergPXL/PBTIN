using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace ExampleInterface
{
    public class Airplane : IFlying
    {
        private int _mps = 100;
        private int _numberOfPassengers;
        private string _code;
        private Image _planeImage;

        public Airplane(int numberOfPassengers, string code)
        {
            _numberOfPassengers = numberOfPassengers;
            _code = code;
        }

        public int Mps => _mps;

        public void DisplayOn(Canvas canvas)
        {
            _planeImage = new Image
            {
                Source = new BitmapImage(new Uri(@"airplane.png", UriKind.RelativeOrAbsolute)),
                Margin = new Thickness(50, 150, 0, 0),
                Width = 150,
                Height = 150
            };
            canvas.Children.Add(_planeImage);
        }

        public void Fly()
        {
            _planeImage.Margin = new Thickness(50, 15, 0, 0);
        }

        public void Land()
        {
            _planeImage.Margin = new Thickness(50, 150, 0, 0);
        }
    }
}
