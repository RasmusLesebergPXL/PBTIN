using System.Windows;
using System.Windows.Controls;
using System.Windows.Shapes;

namespace Shapes
{
    public class Square : Shape
    {
        private Rectangle _rectangle;

        public Square(int initX, int initY)
        {
            _x = initX;
            _y = initY;
            CreateRectangle();
        }

        public override void DisplayOn(Canvas drawArea)
        {
            drawArea.Children.Add(_rectangle);
        }

        private void CreateRectangle()
        {
            _rectangle = new Rectangle()
            {
                Stroke = brush,
                Width = _size,
                Height = _size,
                Margin = new Thickness(_x, _y, 0, 0)
            };
        }
    }
}
