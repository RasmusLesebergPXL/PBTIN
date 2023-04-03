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

namespace oef_4._11_binair
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

        private void transformBinair_Click(object sender, RoutedEventArgs e)
        {
            int input;
            input = Convert.ToInt32(inputNumber.Text);
            string binaryOutcome = Convert.ToString(input, 2);
            binairResult.Text = binaryOutcome;
                
        }
    }
}
