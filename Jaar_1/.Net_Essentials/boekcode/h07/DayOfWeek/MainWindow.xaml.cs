using System;
using System.Windows;

namespace DayOfWeek
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            dayLabel.Content = dayOfWeek2(Convert.ToInt32(daySlider.Value));
            daySlider.ValueChanged += daySlider_ValueChanged;
        }

        private void daySlider_ValueChanged(object sender,
                        RoutedPropertyChangedEventArgs<double> e)
        {
            dayLabel.Content = dayOfWeek2(Convert.ToInt32(daySlider.Value));
        }

        private string dayOfWeek1(int dayNumber)
        {
            string dayName = "";

            if (dayNumber == 1)
            {
                dayName = "Monday";
            }
            else if (dayNumber == 2)
            {
                dayName = "Tuesday";
            }
            else if (dayNumber == 3)
            {
                dayName = "Wednesday";
            }
            else if (dayNumber == 4)
            {
                dayName = "Thursday";
            }
            else if (dayNumber == 5)
            {
                dayName = "Friday";
            }
            else if (dayNumber == 6)
            {
                dayName = "Saturday";
            }
            else if (dayNumber == 7)
            {
                dayName = "Sunday";
            }

            return dayName;
        }

        private string dayOfWeek2(int dayNumber)
        {
            string dayName = "";

            switch (dayNumber)
            {
                case 1:
                    dayName = "Monday";
                    break;
                case 2:
                    dayName = "Tuesday";
                    break;
                case 3:
                    dayName = "Wednesday";
                    break;
                case 4:
                    dayName = "Thursday";
                    break;
                case 5:
                    dayName = "Friday";
                    break;
                case 6:
                    dayName = "Saturday";
                    break;
                case 7:
                    dayName = "Sunday";
                    break;
            }

            return dayName;
        }
    }
}
