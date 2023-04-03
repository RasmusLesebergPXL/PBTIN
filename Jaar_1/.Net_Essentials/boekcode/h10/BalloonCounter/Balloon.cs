using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BalloonCounter
{
    public class Balloon
    {
        private static int _count = 0;
        
        private int _x;
        private int _y;
        private int _diameter;
        private Ellipse _ellipse;

        public Balloon(int initialX = 50,
                       int initialY = 50,
                       int initialDiameter = 20)
        {
            _count++;
            _x = initialX;
            _y = initialY;
            _diameter = initialDiameter;

            CreateEllipse();
            UpdateEllipse();
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

        public static int Count => _count;

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
