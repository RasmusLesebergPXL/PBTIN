using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace Raindrops
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Random _randomGenerator = new Random();
        private SolidColorBrush _brush;
        private DispatcherTimer _timer = new DispatcherTimer();

        public MainWindow()
        {
            InitializeComponent();
            
            gapLabel.Content = Convert.ToString(gapSlider.Value);
            _brush = new SolidColorBrush(Colors.Blue);
            _timer.Interval = TimeSpan.FromMilliseconds(gapSlider.Value);
            _timer.Tick += Timer_Tick;
        }

        private void startButton_Click(object sender, RoutedEventArgs e)
        {
            _timer.Start();
        }

        private void stopButton_Click(object sender, RoutedEventArgs e)
        {
            _timer.Stop();
        }

        private void clearButton_Click(object sender, RoutedEventArgs e)
        {
            paperCanvas.Children.Clear();
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            double x = _randomGenerator.Next(0, Convert.ToInt32(paperCanvas.Width));
            double y = _randomGenerator.Next(0, Convert.ToInt32(paperCanvas.Height));
            double size = _randomGenerator.Next(1, 40);

            //Ellipse ellipse = new Ellipse();
            //ellipse.Width = size;
            //ellipse.Height = size;
            //ellipse.Stroke = brush;
            //ellipse.Fill = brush;
            //ellipse.Margin = new Thickness(x, y, 0, 0);
            var ellipse = new Ellipse()
            {
                Width = size,
                Height = size,
                Stroke = _brush,
                Fill = _brush,
                Margin = new Thickness(x, y, 0, 0)
            };
            paperCanvas.Children.Add(ellipse);

            // set new interval for timer
            _timer.Stop();
            int ms = _randomGenerator.Next(1, Convert.ToInt32(gapSlider.Value));
            _timer.Interval = TimeSpan.FromMilliseconds(ms);
            _timer.Start();
        }

        private void gapSlider_ValueChanged(object sender,
                                RoutedPropertyChangedEventArgs<double> e)
        {
            int timeGap = Convert.ToInt32(gapSlider.Value);
            gapLabel.Content = Convert.ToString(timeGap);
        }
    }
}
