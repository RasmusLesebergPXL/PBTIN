using System;
using System.Windows;

namespace GreaterThan
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

        private void compareButton_Click(object sender, RoutedEventArgs e)
        {
            int a = Convert.ToInt32(input1TextBox.Text);
            int b = Convert.ToInt32(input2TextBox.Text);

            if (a > b)
            {
                resultLabel.Content = $"{a} is greater than {b}";
            }
            else if (b > a)
            {
                resultLabel.Content = $"{b} is greater than {a}";
            }
            else
            {
                resultLabel.Content = "They are equal";
            }
        }
    }
}
