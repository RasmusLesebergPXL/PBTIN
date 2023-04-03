using System;
using System.Windows;

namespace Afronden
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

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            double d1 = 5.5;
            double d2 = 5.5;
            String line = string.Format("afgerond: {0} en {1}",
                                        Math.Round(d1),   /*Math.Round(...,MidpointRounding.AwayFromZero) for proper rounding*/
                                        Convert.ToInt32(d2));
            MessageBox.Show(line);
        }

        private void Button2_Click(object sender, RoutedEventArgs e)
        {
            double d1 = 100000;
            d1 = Math.Pow(d1, d1);
            d1++;
            MessageBox.Show($"Too big: {d1}");
        }
    }
}
