using System;
using System.Media;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;

namespace oef_10._9_Venster
{
    public partial class MainWindow : Window
    {
        private AlarmClock _alarmClock;

        private DispatcherTimer _clockTimer = new DispatcherTimer();
        private DispatcherTimer _alarmTimer = new DispatcherTimer();
        private DateTime _display = new DateTime();
        private int _teller = 0;

        private SolidColorBrush _brush = new SolidColorBrush();
        private SolidColorBrush _colour1 = new SolidColorBrush(Colors.Red);
        private SolidColorBrush _colour2 = new SolidColorBrush(Colors.White);
        public MainWindow()
        {
            InitializeComponent();

            _alarmClock = new AlarmClock();

            _clockTimer.Interval = new TimeSpan(0, 0, 0, 1);
            _alarmTimer.Interval = new TimeSpan(0, 0, 0, 0, 80);
            _clockTimer.Tick += ClockTimer_Tick;
            _alarmTimer.Tick += AlarmTimer_Tick;
            _clockTimer.Start();
        }

        private void ClockTimer_Tick(object sender, EventArgs e)
        {
            _display = DateTime.Now;
            displayTimeTextBlock.Text = Convert.ToString(_display.ToString("HH:mm:ss"));

            if (_alarmClock.IsAlarmPassed())
            {
                _alarmTimer.Start();
                SystemSounds.Beep.Play();

            }
            if (_alarmClock.ShouldStopBeeping())
            {
                _alarmTimer.Stop();
                _alarmClock.Reset();
                alarmTimeTextBox.Text = "";
                displayTimeTextBlock.Background = _colour2;
            }
        }

        private void AlarmTimer_Tick(object sender, EventArgs e)
        {
            displayTimeTextBlock.Background = _brush;

            if (_teller % 2 == 0)
            {
                _brush = _colour2;
            }
            else
            {
                _brush = _colour1;
            }
            _teller++;
        }

        private void SetButton_Click(object sender, RoutedEventArgs e)
        {
            string input = alarmTimeTextBox.Text;
            _alarmClock.SetAlarm(input);
        }
    }
}
