using System.Windows;

namespace MoneyComparisons
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Money _money1;
        private Money _money2;
        
        public MainWindow()
        {
            InitializeComponent();
        }

        private void money1Button_Click(object sender, RoutedEventArgs e)
        {
            _money1 = new Money()
            {
                Amount = 50,
                Currency = "EUR"
            };
            money1TextBlock.Text = $"Created money 1 : {_money1}";
        }

        private void money2Button_Click(object sender, RoutedEventArgs e)
        {
            _money2 = new Money()
            {
                Amount = 50,
                Currency = "EUR"
            };
            money2TextBlock.Text = $"Created money 2 : {_money1}";
        }

        private void compareButton_Click(object sender, RoutedEventArgs e)
        {
            if (_money1.Equals(_money2))
            {
                compareTextBlock.Text = "These money objects are equal!";
            }
            else
            {
                compareTextBlock.Text = "These money objects are not equal!";
            }
        }
    }
}
