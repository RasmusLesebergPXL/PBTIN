using System;
using System.Windows;

namespace Exercise13
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void berekenButton_Click(object sender, RoutedEventArgs e)
        {
            double input = Convert.ToDouble(priceTextBox.Text);
            double btw;
            if ((bool)checkBox.IsChecked)
            {
                btw = 0.06;
            } else
            {
                btw = 0.21;
            }
            btwTextBox.Text = Convert.ToString(input * btw);
            totaalTextBox.Text = Convert.ToString(input + (input * btw));

        }
    }
}
