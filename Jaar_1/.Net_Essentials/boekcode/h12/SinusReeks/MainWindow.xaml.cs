using System;
using System.Windows;

namespace SinusReeks
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            String line = $"{Sin(14)} en {Math.Sin(14)}";
            MessageBox.Show(line);
        }

        private double Sin(double x)
        {
            double term = x;
            double result = 0.0;

            int n = 1;
            while (Math.Abs(term) >= 0.0001)
            {
                result += term;
                term = -term * x * x / ((n + 1) * (n + 2));
                n += 2;
            }
            return result;
        }
    }
}
