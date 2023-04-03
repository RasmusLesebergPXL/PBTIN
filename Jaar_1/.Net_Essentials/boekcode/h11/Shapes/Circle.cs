using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Shapes
{
    public class Circle : Shape
    {
        private Ellipse _ellipse;

        public Circle()
        {
            _xCoord = 40;
            _yCoord = 40;
            _size = 80;
        }

        public override void CreatePhysicalShape(Canvas drawingCanvas)
        {
            _ellipse = new Ellipse();
            _ellipse.Stroke = new SolidColorBrush(Colors.Black);
            _ellipse.StrokeThickness = 2;
            _ellipse.Width = _size;
            _ellipse.Height = _size;
            _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);

            drawingCanvas.Children.Add(_ellipse);

        }

        public override void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
                _ellipse.Height = _size;
                _ellipse.Width = _size;
            }
        }
    }
}
