using System;
using System.Windows;


namespace oef_4._10_bankrekening
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

        private void calculateButton(object sender, RoutedEventArgs e)
        {
            int input, years;
            double interest;
            input = Convert.ToInt32(inputAmount.Text);
            interest = Convert.ToDouble(interestRate.Text);
            years = Convert.ToInt32(amountYears.Text);
            double result = input * Math.Pow(1 + (interest / 100), years);
            endAmount.Text = Convert.ToString($"{result:0.00}");            
        }
    }
}
