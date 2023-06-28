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

namespace oef_5._12_Cylinder
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
            double radius = Convert.ToDouble(radiusInput.Text);
            double hoogte = Convert.ToDouble(hoogteInput.Text);

            CalculateCylinderArea(radius, hoogte);
        }

        private void CalculateCylinderArea(double radius, double hoogte)
        {
            double area = (2 * Math.PI * radius * hoogte) + (2 * Math.PI * Math.Pow(radius, 2));
            MessageBox.Show($"De Area van de cylinder bedraagt: {area: 0.00}");
        }
    }
}
