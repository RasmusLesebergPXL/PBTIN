using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;

namespace oef_11._7_WekkerBeep
{
    public partial class MainWindow : Window
    {
        private DispatcherTimer _clockTimer;
        private DispatcherTimer _alarmTimer;

        private AlarmClock alarmClock;

        private SolidColorBrush _brush;
        private Color _color1;
        private Color _color2;

        public MainWindow()
        {
            InitializeComponent();

            _alarm1 = new BeeperAlarmClock();
            _alarm2 = new FlashAlarmClock();

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
            displayTimeTextBlock.Text = _alarm1.CurrentTime;

            if ((bool) beepButton.IsChecked)
            {
                if (_alarm1.IsAlarmPassed())
                {
                    _alarmTimer.Start();
                }
                if (_alarm1.ShouldStopBeeping())
                {
                    _alarmTimer.Stop();
                    _alarm1.Reset();
                    beepButton.IsChecked = false;
                    alarmTimeTextBox.Text = "";
                    _brush.Color = _color1;
                }
            }
            else if ((bool) flashButton.IsChecked)
            {
                if (_alarm2.IsAlarmPassed())
                {
                    _alarmTimer.Start();
                }
                if (_alarm2.ShouldStopBeeping())
                {
                    _alarmTimer.Stop();
                    _alarm2.Reset();
                    flashButton.IsChecked = false;
                    alarmTimeTextBox.Text = "";
                    _brush.Color = _color1;
                }
            }
        }

        private void AlarmTimer_Tick(object? sender, EventArgs e)
        {
            if ((bool) beepButton.IsChecked) 
            {
                _alarm1.Beep();
            } else if((bool) flashButton.IsChecked)
            {
                _brush.Color = _brush.Color == _color1 ? _color2 : _color1;
                //_alarm2.Flash();
            }
        }

        private void SetButton_Click(object sender, RoutedEventArgs e)
        {
            if ((bool) beepButton.IsChecked)
            {
                _alarm1.AlarmTime = alarmTimeTextBox.Text;
            }
            else if ((bool) flashButton.IsChecked)
            {
                _alarm2.AlarmTime = alarmTimeTextBox.Text;
            }
        }
    }
}
