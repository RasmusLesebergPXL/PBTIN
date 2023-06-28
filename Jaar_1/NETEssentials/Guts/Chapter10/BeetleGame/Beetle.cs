using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BeetleGame
{
    public class Beetle
    {
        private int _xStep;
        private int _yStep;
        private Canvas _canvas;
        private Ellipse _ellipse;
        private bool _right;
        private bool _up;
        private bool _visible;

        public Beetle(Canvas canvas, int x, int y, int size)
        {
            Size = size;
            X = x;
            Y = y;
            _canvas = canvas;
            DrawBeetle();
            Up = true;
            Right = true;
        }

        public double Speed { get; set; }
        public int X { get; set; }
        public int Y { get; set; }
        public int Size { get; set; }
        public bool IsVisible
        {
            get { return _visible; }
            set { _visible = value; SetVisible(); }
        }

        public bool Right
        {
            get { return _right; }
            set { _right = value; XShift(); }
        }

        public bool Up
        {
            get { return _up; }
            set { _up = value; YShift(); }
        }

        public void DrawBeetle()
        {
            _ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Red),
                Fill = new SolidColorBrush(Colors.Red),
                Width = Size,
                Height = Size,
                Margin = new Thickness(X - (Size / 2), Y - (Size / 2), 0, 0)
            };
            _canvas.Children.Add(_ellipse);
        }

        private void XShift()
        {
            if (Right)
            {
                _xStep = 1;
            } else
            {
                _xStep = -1;
            }
            UpdatePosition();
        }

        private void YShift()
        {
            if (Up)
            {
                _yStep = -1;
            } else
            {
                _yStep = 1;
            }
            UpdatePosition();
        }

        private void SetVisible()
        {
            if (!IsVisible)
            {
                _ellipse.Visibility = Visibility.Hidden;
                return;
            } 
            _ellipse.Visibility = Visibility.Visible;
        }

        public void ChangePosition()
        {
            if (Speed <= 0)
            {
                return;
            }

            X += _xStep;
            Y += _yStep;

            UpdatePosition();

            if (X - (Size / 2) <= 0 || X >= (_canvas.Width - (Size / 2)))
            {
                Right = !Right;
            }
            if (Y - (Size / 2) <= 0 || Y >= (_canvas.Height - (Size / 2)))
            {
                Up = !Up;
            }
        }

        private void UpdatePosition()
        {
            _ellipse.Width = Size;
            _ellipse.Height = Size;
            _ellipse.Margin = new Thickness(X - (Size / 2), Y - (Size / 2), 0, 0);
        }
            
        public double ComputeDistance(DateTime start, DateTime finish)
        {
            TimeSpan difference = finish.Subtract(start);
            return  difference.TotalSeconds * Speed / 100;
        }
    }
}
