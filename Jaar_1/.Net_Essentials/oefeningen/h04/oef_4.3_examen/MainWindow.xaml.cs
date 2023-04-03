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

namespace oef_4._3_examen
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

        private void averageCalc_Click(object sender, RoutedEventArgs e)
        {
            int outcomeStudent1 = 44;
            int outcomeStudent2 = 51;
            double average = (outcomeStudent1 + outcomeStudent2) / 2.0;
            examResult.Text = Convert.ToString($"{average:0.0}");
        }
    }
}
