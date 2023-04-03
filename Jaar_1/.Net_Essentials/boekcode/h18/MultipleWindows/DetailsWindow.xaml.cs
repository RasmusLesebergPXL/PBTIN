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
using System.Windows.Shapes;

namespace MultipleWindows
{
    /// <summary>
    /// Interaction logic for DetailsWindow.xaml
    /// </summary>
    public partial class DetailsWindow : Window
    {
        private MainWindow _otherWindow;
        
        public DetailsWindow(MainWindow other)
        {
            InitializeComponent();
            _otherWindow = other;
        }

        private void hideButton_Click(object sender, RoutedEventArgs e)
        {
            _otherWindow.Hide();
        }

        private void showButton_Click(object sender, RoutedEventArgs e)
        {
            _otherWindow.Show();
        }
    }
}
