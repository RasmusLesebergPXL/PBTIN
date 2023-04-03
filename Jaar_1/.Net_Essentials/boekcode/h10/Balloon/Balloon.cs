using System;
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
        private int _diameter = 20;
        private Ellipse _ellipse;

        public Balloon()
        {
            CreateEllipse();
            UpdateEllipse();
        }

        public Balloon(int initialX)
        {
            _x = initialX;
         
            CreateEllipse();
            UpdateEllipse();
        }

        public Balloon(int initialX, int initialY)
        {
            _x = initialX;
            _y = initialY;
            CreateEllipse();
            UpdateEllipse();
        }

        public Balloon(int initialX,
                       int initialY,
                       int initialDiameter)
        {
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

        public double Area
        {
            get
            {
                return this.CalculateArea();
            }
        }

        //public double Area
        //{
        //    get => CalculateArea();
        //}

        private double CalculateArea()
        {
            double radius = _diameter / 2.0;
            return Math.PI * radius * radius;
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
