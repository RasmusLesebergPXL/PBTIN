using System;
using System.Windows;

namespace Exercise08
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
            int lijnA = Convert.ToInt32(textBoxA.Text);
            int lijnB = Convert.ToInt32(textBoxB.Text);
            int lijnC = Convert.ToInt32(textBoxC.Text);

            if (CheckSides(lijnA, lijnB, lijnC))
            {
                errorTextBlock.Text = "";
                double area = AreaFunction(lijnA, lijnB, lijnC);
                areaTextBlock.Text = Convert.ToString(area.ToString("#.000"));
            } else
            {
                errorTextBlock.Text = "Deze zijden kunnen nooit een driehoek vormen";
                textBoxA.Text = "";
                textBoxB.Text = "";
                textBoxC.Text = "";
                areaTextBlock.Text = "";
            }
        }

        private bool CheckSides(int a, int b, int c)
        {
            if ((a > (b + c)) || (b > (a + c)) || (c > (a + b)))
            {
                return false;
            } else if (a < 0 || b < 0 || c < 0)
            {
                return false;
            }
            return true;
        }

        //Deze functie doet verder niks in dit programma maar wordt wel vereist in de testen
        private int Max(int a, int b, int c)
        {
            if (b > a && c < b)
            {
                return b;
            }
            else if (c > b && a < c)
            {
                return c;
            }
            return a;
        }

        private double AreaFunction(int a, int b, int c)
        {
            double s = (a + b + c) / 2.0;
            return Math.Sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }
}
