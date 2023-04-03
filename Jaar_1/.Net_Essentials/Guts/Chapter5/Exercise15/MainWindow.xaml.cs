using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Exercise15
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void convertButton_Click(object sender, RoutedEventArgs e)
        {
            int totalSeconds = Convert.ToInt32(timeInSecondsTextBox.Text);
            ConvertSecondsToHoursMinutesSeconds(totalSeconds,
                                                out int hours,
                                                out int minutes,
                                                out int seconds);

        }

        private void ConvertSecondsToHoursMinutesSeconds(int totalSeconds,
                                                         out int hours,
                                                         out int minutes,
                                                         out int seconds)
        {
            hours = totalSeconds / 3600;
            totalSeconds -= 3600 * hours;

            minutes = totalSeconds / 60;
            totalSeconds -= 60 * minutes;

            seconds = totalSeconds;

            hourTextBox.Text = Convert.ToString(hours);
            minuteTextBox.Text = Convert.ToString(minutes);
            secondsTextBox.Text = Convert.ToString(seconds);

        }
    }
}
