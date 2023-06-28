using System;
using System.Windows;

namespace Exercise11
{
    public partial class MainWindow : Window
    {
        Random _generatorOne = new Random(5000);
        Random _generatorTwo = new Random(4000);
        public MainWindow()
        {
            InitializeComponent();
            fieldOneLabel.Content = Convert.ToString(_generatorOne.Next());
            fieldTwoLabel.Content = Convert.ToString(_generatorTwo.Next());
        }

        private void buttonOne_Click(object sender, RoutedEventArgs e)
        {
            fieldOneLabel.Content = Convert.ToString(_generatorOne.Next());
        }

        private void buttonTwo_Click(object sender, RoutedEventArgs e)
        {
            fieldTwoLabel.Content = Convert.ToString(_generatorTwo.Next());
        }
    }
}
