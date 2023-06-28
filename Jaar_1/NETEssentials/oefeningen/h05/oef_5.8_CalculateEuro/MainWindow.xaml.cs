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

namespace oef_5._8_CalculateEuro
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

        private void berekenButton_Click(object sender, RoutedEventArgs e)
        {
            double dollar = Convert.ToDouble(dollarInput.Text);
            CalculateEuroEquivalent(dollar);
            double euro = CalculateEuroEquivalent(dollar);
            euroOutput.Text = Convert.ToString($"{euro: 0.00}");
        }

        private double CalculateEuroEquivalent(double dollar)
        {
            return dollar * 0.89;
        }
    }
}
