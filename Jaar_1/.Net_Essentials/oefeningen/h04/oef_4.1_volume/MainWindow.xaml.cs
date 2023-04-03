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

namespace oef_4._1_volume
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
            int length, height, depth;
            length = Convert.ToInt32(amountLength.Text);
            height = Convert.ToInt32(amountHeight.Text);
            depth = Convert.ToInt32(amountDepth.Text);
            volumeTextBlock.Text = Convert.ToString(length * height * depth);
        }
    }
}
