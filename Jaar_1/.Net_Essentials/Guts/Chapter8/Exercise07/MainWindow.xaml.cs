using System;
using System.Diagnostics;
using System.Windows;

namespace Exercise07
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

        private void TekenButton_Click(object sender, RoutedEventArgs e)
        {
            int getal = Convert.ToInt32(getalInputTextBox.Text);

            outputTextBlock.Text += "\t";
            for (int i = 1; i <= getal; i++)
            {
                outputTextBlock.Text += Convert.ToString(i + "\t");
                Debug.WriteLine(i + " keer gedaan");
            }
            outputTextBlock.Text += "\n\n";


            for (int i = 1; i <= getal; i++)
            {
                outputTextBlock.Text += Convert.ToString(i + "\t");
                for (int j = 1; j <= getal; j++)
                {
                    outputTextBlock.Text += Convert.ToString(i * j + "\t");
                }
                outputTextBlock.Text += "\n";
            }
        }
    }
}
