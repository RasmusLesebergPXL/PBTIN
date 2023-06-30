using System.Threading;
using System.Windows;

namespace Exercise1
{
    public partial class MainWindow : Window
    {
        private int _counter = 1;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BreakButton_Click(object sender, RoutedEventArgs e)
        {
            if (_counter != 5)
            {
                messageBorder.Visibility = Visibility.Visible;

                if (key1Textbox.Text.Trim().ToString() == "PXL" &&
                key2Passwordbox.Password.ToString() == "ForLife" &&
                key3Checkbox.IsChecked == true &&
                key4Combobox.Text == "Item 3" &&
                key5RadioButton.IsChecked == true)
                {
                    messageTextBlock.Text = "You cracked the code!!";
                }
                else
                {
                    messageTextBlock.Text = $"Invalid code. {5 - _counter} attempts left";
                }
                _counter++;
            }
            else
            {
                messageTextBlock.Text = "Game over";
                breakButton.IsEnabled = false;
            }
        }
    }
}
