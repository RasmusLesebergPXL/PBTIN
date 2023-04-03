using System;
using System.Windows;

namespace Rainfall
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int[] _rainAmounts = { 7, 8, 0, 4, 3, 8, 1 };
        
        public MainWindow()
        {
            InitializeComponent();

            Display();
            ShowLargest();
        }

        private void Display()
        {
            rainfallTextBox.Clear();
            for (int dayNumber = 0; dayNumber < 7; dayNumber++)
            {           
                rainfallTextBox.AppendText($"day {dayNumber} rain ");
                rainfallTextBox.AppendText($"{_rainAmounts[dayNumber]}");
                rainfallTextBox.AppendText(Environment.NewLine);
            }
        }

        private void ModifyAmount()
        {
            int index = Convert.ToInt32(indexTextBox.Text);
            string input = valueTextBox.Text;
            
            if (input == "")
            {
                input = "0";
            }
            int data = Convert.ToInt32(input);

            _rainAmounts[index] = data;
            Display();
            ShowLargest();
        }

        private void ShowLargest()
        {
            int largest = _rainAmounts[0];
            for (int index = 1; index < 7; index++)
            {
                if (largest < _rainAmounts[index])
                {
                    largest = _rainAmounts[index];
                }
            }
            largestLabel.Content = $"Largest value is {largest}";
        }

        private void changeButton_Click(object sender, RoutedEventArgs e)
        {
            ModifyAmount();
        }

        //Testvraag 14.7:
        //private void ShowWeekTotal()
        //{
        //    int total = 0;
        //    foreach (int rainAmount in rainAmounts)
        //    {
        //        total += rainAmount;
        //    }
        //    totalLabel.Content = $"Week total is: {total}";
        //}
    }
}
