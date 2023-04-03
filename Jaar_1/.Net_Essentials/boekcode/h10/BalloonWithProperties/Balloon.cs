using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BalloonWithProperties
{
    public class Balloon
    {
        private int _x = 50;
        private int _y = 50;
        private int _diameter = 20;
        private Ellipse _ellipse;
        
        public Balloon()
        {
            CreateEllipse();
            UpdateEllipse();
        }

        public int XCoord
        {
            get
            {
                return _x;
            }
            set
            {
                _x = value;
                UpdateEllipse();
            }
        }

        public int YCoord
        {
            get
            {
                return _y;
            }
            set
            {
                _y = value;
                UpdateEllipse();
            }
        }

        public void MoveRight(int xStep)
        {
            _x = _x + xStep;
            UpdateEllipse();
        }

        public void ChangeSize(int change)
        {
            _diameter = _diameter + change;
            UpdateEllipse();
        }

        public void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_ellipse);
        }

        private void CreateEllipse()
        {
            _ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Blue),
                StrokeThickness = 2
            };
        }

        private void UpdateEllipse()
        {
            _ellipse.Margin = new Thickness(_x, _y, 0, 0);
            _ellipse.Width = _diameter;
            _ellipse.Height = _diameter;
        }
    }
}
