using System;
using System.Windows;

namespace Buggies
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // IndexOutOfRangeException
            int[] row = new int[10];
            for (int i = 0; i <= 10; i++)
            {
                row[i] = 0;
            }


            // DivideByZeroException
            //int a, b, c;
            //b = 1;
            //c = Convert.ToInt32("0");
            //a = b / c;
        }
    }
}
