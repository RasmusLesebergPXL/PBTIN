using System;
using System.Windows;

namespace Guesser
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Random _ageGuesser = new Random();
        private int _tries = 0;
        
        public MainWindow()
        {
            InitializeComponent();

            guessLabel.Content = Convert.ToString(_ageGuesser.Next(5, 110));
        }

        private void correctButton_Click(object sender, RoutedEventArgs e)
        {
            _tries = _tries + 1;
            MessageBox.Show($"Number of tries was: {_tries}");
            _tries = 0;
            guessLabel.Content = Convert.ToString(_ageGuesser.Next(5, 110));
        }

        private void wrongButton_Click(object sender, RoutedEventArgs e)
        {
            guessLabel.Content = Convert.ToString(_ageGuesser.Next(5, 110));
            _tries = _tries + 1;
        }
    }
}
