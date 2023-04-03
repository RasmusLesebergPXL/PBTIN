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

namespace Car_Park_2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int _carCount = 0;

        public MainWindow()
        {
            InitializeComponent();

            // initialize your own variables and properties
            countLabel.Content = Convert.ToString(_carCount);
        }

        private void enterButton_Click(object sender, RoutedEventArgs e)
        {
            _carCount = _carCount + 1;
            countLabel.Content = Convert.ToString(_carCount);
        }

        private void leaveButton_Click(object sender, RoutedEventArgs e)
        {
            _carCount = _carCount - 1;
            countLabel.Content = Convert.ToString(_carCount);
        }
    }
}
