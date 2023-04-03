using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Threading;

namespace BeetleGame
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Random _randomNumber;
        private Beetle _beetle;
        private DispatcherTimer _timer;

        private DateTime _start;
        private DateTime _stop;

        private int _x;
        private int _y;

        public MainWindow()
        {
            InitializeComponent();

            sizeSlider.ValueChanged += sizeSlider_ValueChanged;
            speedSlider.ValueChanged += speedSlider_ValueChanged;

            _randomNumber = new Random();
            BeetlePosition();

            _beetle = new Beetle(paperCanvas, _x, _y, (int)sizeSlider.Value);
            _beetle.Speed = speedSlider.Value;

            _timer = new DispatcherTimer();
            _timer.Interval = TimeSpan.FromMilliseconds(100 / speedSlider.Value * sizeSlider.Value / 10);
            _timer.Tick += Timer_Tick;
        }

        private void BeetlePosition()
        {
            int x, y;
            double finalPosition;
            
            x = _randomNumber.Next(30, (int)paperCanvas.Width - 30); 
            y = _randomNumber.Next(30, (int)paperCanvas.Height - 30);

            finalPosition = Math.Sqrt(Math.Pow(x, 2) + Math.Pow(y, 2));

            while (finalPosition <= 100)
            {
                x = _randomNumber.Next(30, (int)paperCanvas.Width - 30);
                y = _randomNumber.Next(30, (int)paperCanvas.Height - 30);

                finalPosition = Math.Sqrt(Math.Pow(x, 2) + Math.Pow(y, 2));
            }
            _x = x;
            _y = y;
        }

        private void startButton_Click(object sender, RoutedEventArgs e)
        {
            var clickedOperand = (Button)sender;
            if (clickedOperand.Content.Equals("Start"))
            {
                _timer.Start();
                _start = DateTime.Now;

                startButton.Content = "Stop";
                sizeSlider.IsEnabled = false;
                speedSlider.IsEnabled = false;

                _beetle.IsVisible = true;
            }
            else
            {
                _timer.Stop();
                _stop = DateTime.Now;
                messageLabel.Visibility = Visibility.Visible;
                startButton.Content = "Start";
                sizeSlider.IsEnabled = true;
                speedSlider.IsEnabled = true;

                double distance = _beetle.ComputeDistance(_start, _stop);
                messageLabel.Content = $"The total distance in meter: {distance: 0.00}";
                messageLabel.Background = new SolidColorBrush(Colors.LightPink);
            }
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            _beetle.ChangePosition();
        }

        private void VerticalButton_Click(object sender, RoutedEventArgs e)
        {
            var clickedOperand = (Button)sender;

            if (clickedOperand.Content.Equals("Up") && _beetle.Up == false)
            {
                _beetle.Up = true;
            }
            if (clickedOperand.Content.Equals("Down") && _beetle.Up == true)
            {
                _beetle.Up = false;
            }
            _beetle.ChangePosition();
        }

        private void HorizontalButton_Click(object sender, RoutedEventArgs e)
        {
            var clickedOperand = (Button)sender;

            if (clickedOperand.Content.Equals("Left") && _beetle.Right == true)
            {
                _beetle.Right = false;
            }
            if (clickedOperand.Content.Equals("Right") && _beetle.Right == false)
            {
                _beetle.Right = true;
            }
            _beetle.ChangePosition();
        }

        private void sizeSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            _beetle.Size = (int)sizeSlider.Value;
            _beetle.ChangePosition();
            _timer.Interval = TimeSpan.FromMilliseconds(100 / speedSlider.Value * sizeSlider.Value / 10);
            sizeLabel.Content = Convert.ToString(sizeSlider.Value);
        }

        private void speedSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            _beetle.Speed = speedSlider.Value;
            _timer.Interval = TimeSpan.FromMilliseconds(100 / speedSlider.Value * sizeSlider.Value / 10);
            speedLabel.Content = Convert.ToString(speedSlider.Value);
        }

        private void resetButton_Click(object sender, RoutedEventArgs e)
        {
            messageLabel.Visibility = Visibility.Hidden;
            startButton.Content = "Start";
            sizeSlider.Value = sizeSlider.Minimum;
            speedSlider.Value = speedSlider.Minimum;
            _timer.Stop();
            
            _beetle.IsVisible = false;
        }
    }
};

