using System;
using System.Windows;

namespace InterestCalculation
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int _year = 1;
        private double _oldAmount;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void yearButton_Click(object sender, RoutedEventArgs e)
        {
            double rate, newAmount;
            int euros, cents;

            if (_year == 1)
            {
                _oldAmount = Convert.ToDouble(initialAmountTextBox.Text);
            }

            rate = Convert.ToDouble(rateTextBox.Text);

            newAmount = _oldAmount + (_oldAmount * rate / 100);

            euros = (int)newAmount;
            cents = (int)Math.Round(100 * (newAmount - euros));
            string line = $"After {_year} years the money has become " +
                          $"{euros} euros and {cents} eurocents.";
            resultTextBox.AppendText(line);
            resultTextBox.AppendText(Environment.NewLine);
            resultTextBox.AppendText(Environment.NewLine);

            _oldAmount = newAmount;
            _year += 1;
        }
    }
}
