using System;
using System.Windows;

namespace Exercise03
{
    public partial class MainWindow : Window
    {
        private Random _randomGenerator = new Random();
        private int _teller;
        private double _som;
        public MainWindow()
        {
            InitializeComponent();
            randomNumberTextBox.IsEnabled = false;
            sumTextBox.IsEnabled = false;
            averageTextBox.IsEnabled = false;
        }

        private void genereerButton_Click(object sender, RoutedEventArgs e)
        {
            double getal, gemiddelde;

            _teller += 1;
            getal = _randomGenerator.Next(200, 401);
            _som += getal;
            gemiddelde = _som / _teller;         

            randomNumberTextBox.Text = Convert.ToString(Math.Round(getal, 2));
            sumTextBox.Text = Convert.ToString(Math.Round(_som, 2));
            averageTextBox.Text = Convert.ToString(Math.Round(gemiddelde, 2));
            
        }
    }
}
