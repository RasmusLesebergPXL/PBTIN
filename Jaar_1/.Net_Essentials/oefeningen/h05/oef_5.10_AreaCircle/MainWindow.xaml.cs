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

namespace oef_5._10_AreaCircle
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

        private void areaButton_Click(object sender, RoutedEventArgs e)
        {
            double straal = Convert.ToDouble(radiusInput.Text);
            CalculateCircleArea(straal);
        }

        private void CalculateCircleArea(double radius)
        {
            double area = Math.PI * Math.Pow(radius, 2);
            MessageBox.Show($"De Area bedraagt: {area: 0.00}");
        }
    }
}
