using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Shapes
{
    public class Square : Shape
    {
        private Rectangle _rectangle;

        public Square()
        {
            _xCoord = 40;
            _yCoord = 40;
            _size = 80;
        }

        public override void CreatePhysicalShape(Canvas drawingCanvas)
        {
            _rectangle = new Rectangle();
            _rectangle.Stroke = new SolidColorBrush(Colors.Black);
            _rectangle.StrokeThickness = 2;
            _rectangle.Width = _size;
            _rectangle.Height = _size;
            _rectangle.Margin = new Thickness(_xCoord, _yCoord, 0, 0);

            drawingCanvas.Children.Add(_rectangle);

        }

        public override void Redraw()
        {
            if (_rectangle != null)
            {
                _rectangle.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
                _rectangle.Height = _size;
                _rectangle.Width = _size;
            }
        }
    }
}
