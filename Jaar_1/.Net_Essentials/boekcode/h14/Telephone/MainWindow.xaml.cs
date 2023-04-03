using System.Windows;

namespace Telephone
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const int MaximumEntries = 20;
        private string[] _names = new string[MaximumEntries];
        private string[] _numbers = new string[MaximumEntries];

        public MainWindow()
        {
            InitializeComponent();

            _names[0] = "Alex";
            _numbers[0] = "2720774";

            _names[1] = "Megan";
            _numbers[1] = "5678554";

            _names[2] = "END";
        }

        private void findButton_Click(object sender, RoutedEventArgs e)
        {
            Find();
        }

        private void Find()
        {
            int index = 0;
            string wanted = nameTextBox.Text;

            while (_names[index] != wanted && (_names[index] != "END"))
            {
                index++;
            }
            if (_names[index] == wanted)
            {
                resultLabel.Content = $"Number is {_numbers[index]}";
            }
            else
            {
                resultLabel.Content = "Name not found";
            }
        }
    }
}
