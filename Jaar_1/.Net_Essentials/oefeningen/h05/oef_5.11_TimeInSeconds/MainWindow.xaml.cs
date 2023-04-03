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

namespace oef_5._11_TimeInSeconds
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

        private void aantalSeconden_Click(object sender, RoutedEventArgs e)
        {
            int uren = Convert.ToInt32(urenInput.Text);
            int minuten = Convert.ToInt32(minutenInput.Text);
            int seconden = Convert.ToInt32(secondenInput.Text);

            GetTimeInSeconds(uren, minuten, seconden);
        }

        private void GetTimeInSeconds(int uren, int minuten, int seconden)
        {
            int totaalSeconden = (uren * 3600) + (minuten * 60) + seconden;
            MessageBox.Show($"Aantal seconden: {totaalSeconden}");
        }
    }
}
