using System;
using System.Collections.Generic;
using System.Windows;

namespace Exercise07
{
    public partial class MainWindow : Window
    {
        private IList<string> _months;
        public MainWindow()
        {
            InitializeComponent();

            _months = new List<string>();
            _months.Add("January");
            _months.Add("February");
            _months.Add("March");
            _months.Add("April");
            _months.Add("May");
            _months.Add("June");
            _months.Add("July");
            _months.Add("August");
            _months.Add("September");
            _months.Add("October");
            _months.Add("November");
            _months.Add("December");
        }

        private void lookupButton_Click(object sender, RoutedEventArgs e)
        {
            int index = Convert.ToInt32(monthNumberTextBox.Text) - 1;
            monthNameTextBox.Text = _months[index];
        }
    }
}
