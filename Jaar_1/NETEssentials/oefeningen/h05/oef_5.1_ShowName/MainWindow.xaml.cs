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

namespace oef_5._1_ShowName
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

        private void showNameButton_Click(object sender, RoutedEventArgs e)
        {
            string naam = voornaamInput.Text;
            ShowName(naam);
        }

        private void ShowName(string naam)
        {
            MessageBox.Show($"De ingegeven voornaam was {naam}");
        }
    }
}
