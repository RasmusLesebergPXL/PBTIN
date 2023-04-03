using System;
using System.Windows;

namespace oef_10._4_ScoreTeller
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Score _score;
        public MainWindow()
        {
            _score = new Score();
            InitializeComponent();
        }

        private void verhoogButton_Click(object sender, RoutedEventArgs e)
        {
            _score.Ophogen();
            scoreTextBlock.Text = Convert.ToString(_score.GetScore());
        }

        private void verlaagButton_Click(object sender, RoutedEventArgs e)
        {
            _score.Verlagen();
            scoreTextBlock.Text = Convert.ToString(_score.GetScore());
        }

        private void resetButton_Click(object sender, RoutedEventArgs e)
        {
            _score.Reset();
            scoreTextBlock.Text = Convert.ToString(_score.GetScore());
        }
    }
}
