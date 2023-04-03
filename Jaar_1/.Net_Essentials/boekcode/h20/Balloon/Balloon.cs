using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BalloonApp
{
    public class Balloon
    {
        private int _x = 50;
        private int _y = 50;
        private int _radius = 20;
        private Ellipse _ellipse;

        public Balloon()
        {
            _x = 50;
            _y = 50;
            _radius = 20;

            CreateEllipse();
            UpdateEllipse();
        }

        public void MoveUp(int yStep)
        {
            _y -= yStep;
            UpdateEllipse();
        }

        public void MoveDown(int yStep)
        {
            _y += yStep;
            UpdateEllipse();
        }

        public void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_ellipse);
        }

        public int Radius
        {
            get { return _radius; }
            set { _radius = value; UpdateEllipse(); }
        }

        private void CreateEllipse()
        {
            _ellipse = new Ellipse();
            _ellipse.Stroke = new SolidColorBrush(Colors.Blue);
            _ellipse.StrokeThickness = 2;
        }

        private void UpdateEllipse()
        {
            _ellipse.Margin = new Thickness(_x, _y, 0, 0);
            _ellipse.Width = _radius * 2;
            _ellipse.Height = _radius * 2;
        }
    }
}
