using System;
using System.Windows;
using System.Windows.Threading;

namespace Exercise06
{
    public partial class MainWindow : Window
    {
        private DispatcherTimer _timer = new DispatcherTimer();
        private int _seconden = 0;
        private int _minuten = 0;

       
        public MainWindow()
        {
            InitializeComponent();
            _timer.Interval = new System.TimeSpan(0, 0, 1);
            _timer.Tick += Timer_Tick;
            _timer.Start();
        }

        private void Timer_Tick(object sender, EventArgs e)
        {        
            secondRectangle.Width += _timer.Interval.TotalSeconds * 10;
            _seconden++;
            minuteRectangle.Width += _timer.Interval.TotalMinutes * 10;
            _minuten++;

            if (_seconden % 60 == 0)
            {
                secondRectangle.Width = 0;
                minuteRectangle.Width += 10;
            }
            if (_minuten % 3600 == 0)
            {
                minuteRectangle.Width = 0;
            }
        }

    }
}
