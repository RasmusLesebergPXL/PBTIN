using System;
using System.Windows;

namespace RandomNumberTotal
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int _generatedNumber;
        private Random _random;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void generateButton_Click(object sender, RoutedEventArgs e)
        {
            _random = new Random();
            _generatedNumber = _random.Next(5, 100);

            generateTextBlock.Text = $"{_generatedNumber}";
        }

        private void calculateButton_Click(object sender, RoutedEventArgs e)
        {
            int sum = 0;
            for (int i = 1; i <= _generatedNumber; i++)
            {
                sum = sum + i;
            }
            sumTextBlock.Text = $"De som van 1 tot en met {_generatedNumber} is {sum}";
        }
    }
}
