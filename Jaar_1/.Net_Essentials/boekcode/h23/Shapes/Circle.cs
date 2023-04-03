using System.Windows;
using System.Windows.Controls;
using System.Windows.Shapes;

namespace Shapes
{
    public class Circle : Shape
    {
        private Ellipse _ellipse;

        public Circle(int initX, int initY)
        {
            _x = initX;
            _y = initY;
            CreateEllipse();
        }

        public override void DisplayOn(Canvas drawArea)
        {
            drawArea.Children.Add(_ellipse);
        }

        private void CreateEllipse()
        {
            _ellipse = new Ellipse()
            {
                Stroke = brush,
                Width = _size,
                Height = _size,
                Margin = new Thickness(_x, _y, 0, 0)
            };
        }
    }
}
