using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;

namespace oef_10._8_Wekker
{
    public partial class MainWindow : Window
    {
        private DispatcherTimer _clockTimer;
        private DispatcherTimer _alarmTimer;

        private AlarmClock _alarmClock;

        private SolidColorBrush _brush;
        private Color _color1;
        private Color _color2;

        public MainWindow()
        {
            InitializeComponent();

            _alarmClock = new AlarmClock();

            _color1 = Colors.White;
            _color2 = Colors.Tomato;
            _brush = new SolidColorBrush(_color1);
            displayTimeTextBlock.Background = _brush;

            _clockTimer = new DispatcherTimer();
            _alarmTimer = new DispatcherTimer();

            _clockTimer.Interval = TimeSpan.FromSeconds(1);
            _alarmTimer.Interval = TimeSpan.FromMilliseconds(300);

            _clockTimer.Tick += ClockTimer_Tick;
            _alarmTimer.Tick += AlarmTimer_Tick;

            _clockTimer.Start();
        }

        private void ClockTimer_Tick(object? sender, EventArgs e)
        {
            displayTimeTextBlock.Text = _alarmClock.CurrentTime;

            if (_alarmClock.IsAlarmPassed())
            {
                _alarmTimer.Start();
            }
            if (_alarmClock.ShouldStopBeeping())
            {
                _alarmTimer.Stop();
                _alarmClock.Reset();
                alarmTimeTextBox.Text = "";
                _brush.Color = _color1;
            }
        }

        private void AlarmTimer_Tick(object? sender, EventArgs e)
        {
            _brush.Color = _brush.Color == _color1 ? _color2 : _color1;
        }

        private void SetButton_Click(object sender, RoutedEventArgs e)
        {
            _alarmClock.AlarmTime = alarmTimeTextBox.Text;
        }
    }
    }
