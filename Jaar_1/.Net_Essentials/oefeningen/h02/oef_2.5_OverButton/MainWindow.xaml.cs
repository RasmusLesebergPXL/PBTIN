
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

namespace oef_2._5_OverButton
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

        private void niceButton_MouseEnter(object sender, MouseEventArgs e)
        {
            niceButton.Content = "Over Button";
        }

        private void niceButton_MouseLeave(object sender, MouseEventArgs e)
        {
            niceButton.Content = "Button";
        }
    }
}
