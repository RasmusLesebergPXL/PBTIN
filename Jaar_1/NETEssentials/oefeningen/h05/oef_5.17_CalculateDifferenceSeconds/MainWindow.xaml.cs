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

namespace oef_5._17_CalculateDifferenceSeconds
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
        private void timeButton_Click(object sender, RoutedEventArgs e)
        {
            int t1Uur = Convert.ToInt32(tijd1Uur.Text);
            int t1Minuut = Convert.ToInt32(tijd1Minuut.Text);
            int t1Seconden = Convert.ToInt32(tijd1Seconden.Text);
            int t2Uur = Convert.ToInt32(tijd2Uur.Text);
            int t2Minuten = Convert.ToInt32(tijd2Minuten.Text);
            int t2Seconden = Convert.ToInt32(tijd2Seconden.Text);

            CalculateTimeDifferenceInSeconds(t1Uur, t1Minuut, t1Seconden, t2Uur, t2Minuten, t2Seconden);
        }

        private void CalculateTimeDifferenceInSeconds(int t1Uur, int t1Minuut, int t1Seconden, 
                                                      int t2Uur, int t2Minuten, int t2Seconden)
        {
            int uurDiffernce = 0;
            int minuutDifference = 0;
            int secondenDifference = 0;
            if (t1Uur < t2Uur) {
                uurDiffernce = t2Uur - t1Uur;
            } else
            {
                uurDiffernce = t1Uur - t2Uur;
            }
            if (t1Minuut < t2Minuten) {
                minuutDifference = t2Minuten - t1Minuut;
            } else
            {
                minuutDifference = t1Minuut - t2Minuten;
            }
            if (t1Seconden < t2Seconden)
            {
                secondenDifference = t2Seconden - t1Seconden;
            } else
            {
                secondenDifference = t1Seconden - t2Seconden;
            }

            MessageBox.Show($"uur: {uurDiffernce}\n" +
                            $"minuten: {minuutDifference}\n" +
                            $"seconden: {secondenDifference}");
        }
    }
}
