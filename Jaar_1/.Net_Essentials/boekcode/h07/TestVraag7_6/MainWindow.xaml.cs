using System;
using System.Windows;

namespace TestVraag7_6
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            slider1.ValueChanged += CheckValues;
            slider2.ValueChanged += CheckValues;
            slider3.ValueChanged += CheckValues;
        }

        private void CheckValues(object sender,
                          RoutedPropertyChangedEventArgs<double> e)
        {
            double a = slider1.Value;
            double b = slider2.Value;
            double c = slider3.Value;
            double largest = a;

            if (b > largest)
            {
                largest = b;
            }

            if (c > largest)
            {
                largest = c;
            }

            messageLabel.Content = String.Format("largest value is {0:0.00}", largest);
        }
    }
}
