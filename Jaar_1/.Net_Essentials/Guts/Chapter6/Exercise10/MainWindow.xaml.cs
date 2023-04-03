using System;
using System.Windows;
using System.Windows.Threading;

namespace Exercise10
{
    public partial class MainWindow : Window
    {
        private DispatcherTimer _timer = new DispatcherTimer();
        public MainWindow()
        {
            InitializeComponent();
            _timer.Start();
            _timer.Interval = new TimeSpan(0, 0, 1);
            progressBar1.Maximum = 5;
            _timer.Tick += new EventHandler(Timer_Tick);
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            if (progressBar1.Value != progressBar1.Maximum)
            {
                progressBar1.Value++;
            }
            else
            {
                MessageBox.Show("U hebt slechts vijf seconden om in te loggen.");
                _timer.Stop();
                okButton.IsEnabled = false;
            }
        }


    }

    internal record struct NewStruct(int Item1, int Item2, int Item3)
    {
        public static implicit operator (int, int, int)(NewStruct value)
        {
            return (value.Item1, value.Item2, value.Item3);
        }

        public static implicit operator NewStruct((int, int, int) value)
        {
            return new NewStruct(value.Item1, value.Item2, value.Item3);
        }
    }
}
