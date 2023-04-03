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

namespace oef_2._1_Demo
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

        private void Button_1_Click(object sender, RoutedEventArgs e)
        {
            label_1.Content = "JA";
            label_2.Content = "JA";
            label_3.Content = "JA";
        }

        private void Button_2_Click(object sender, RoutedEventArgs e)
        {
            label_1.Content = "NEE";
            label_2.Content = "NEE";
            label_3.Content = "NEE";
        }

        private void Button_3_Click(object sender, RoutedEventArgs e)
        {
            label_1.Content = "A";
            label_2.Content = "B";
            label_3.Content = "C";
        }
    }
}
