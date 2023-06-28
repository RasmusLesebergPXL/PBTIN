using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace oef_11._2_PoolBall
{
    public class Sphere
    {
        protected int _xCoord = 100;
        protected int _yCoord = 100;
        protected Ellipse _ellipse;

        public int X
        {
            set { _xCoord = value; Redraw(); }
            get { return _xCoord; }
        }

        public int Y
        {
            set { _yCoord = value; Redraw(); }
            get { return _yCoord; }
        }

        public virtual void CreateEllipse(Canvas drawingCanvas)
        {
            _ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Black),
                StrokeThickness = 2,
                Width = 40,
                Height = 40,
                Margin = new Thickness(_xCoord, _yCoord, 0, 0)
            };
            drawingCanvas.Children.Add(_ellipse);
        }

        public virtual void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
            }
        }
    }
}
