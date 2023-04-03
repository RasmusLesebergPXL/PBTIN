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

namespace oef_5._3_ShowSalary
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
            int salaris = Convert.ToInt32(salarisInput.Text);
            int jaren = Convert.ToInt32(jarenInput.Text);
            ShowSalary(salaris, jaren);
        }

        private void ShowSalary(int hoeveelheidSalaris, int aantalJaren)
        {
            MessageBox.Show($"De werknemer heeft {hoeveelheidSalaris * aantalJaren} verdiend");
        }
    }
}
