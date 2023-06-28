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

namespace oef_5._16_GetInput3
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

        private void getInput_Click(object sender, RoutedEventArgs e)
        {
            GetInput3(out int a, out int b, out int c);
        }

        private void GetInput3(out int a, out int b, out int c)
        {
            a = Convert.ToInt32(getalEen.Text);
            b = Convert.ToInt32(getalTwee.Text);
            c = Convert.ToInt32(getalDrie.Text);
            MessageBox.Show($"getal een: {a}\ngetal twee: {b}\ngetal drie: {c}");
        }
    }
}
