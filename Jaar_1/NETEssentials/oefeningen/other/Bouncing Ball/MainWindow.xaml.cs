using System;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace Bouncing_Ball_Pong
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DispatcherTimer _timer;
        private int _xChange;
        private int _yChange;
        private double _x;
        private double _y;
        private double _diameter;
        private Ellipse _ellipse;

        public MainWindow()
        {
            InitializeComponent();

            _xChange = 10;
            _yChange = 4;

            _x = 10;
            _y = 10;
            _diameter = 15;

            _timer = new DispatcherTimer();
            _timer.Interval = TimeSpan.FromMilliseconds(50);
            _timer.Tick += _timer_Tick;
        }

        private void _timer_Tick(object sender, EventArgs e)
        {
            MoveBall();
        }


        private void ballCanvas_MouseUp(object sender, MouseButtonEventArgs e)
        {
            DrawBall(_x, _y, _diameter);
            _timer.Start();
        }

        private void MoveBall()
        {
            if ((_x <= 0) || (_x >= ballCanvas.Width - _diameter))
            {
                _xChange = -_xChange;
            }
            if ((_y <= 0) || (_y >= ballCanvas.Height - _diameter))
            {
                _yChange = -_yChange;
            }

            _x = _x + _xChange;
            _y = _y + _yChange;

            _ellipse.Margin = new Thickness(_x, _y, 0, 0);
        }

        private void DrawBall(double x, double y, double diameter)
        {
            _ellipse = new Ellipse()


            {
                Stroke = new SolidColorBrush(Colors.Blue),
                Width = diameter,
                Height = diameter,
                Margin = new Thickness(x, y, 0, 0)
            };
            ballCanvas.Children.Add(_ellipse);
        }
    }
}
