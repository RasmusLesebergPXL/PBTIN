using System.Windows;

namespace BalloonComparisons
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Balloon _balloon1;
        private Balloon _balloon2;
        
        public MainWindow()
        {
            InitializeComponent();
        }

        private void balloon1Button_Click(object sender, RoutedEventArgs e)
        {
            _balloon1 = new Balloon();
            _balloon1.DisplayOn(drawingCanvas);
            balloon1TextBlock.Text = $"Created balloon 1: {_balloon1}";
        }

        private void balloon2Button_Click(object sender, RoutedEventArgs e)
        {
            _balloon2 = new Balloon();
            _balloon2.DisplayOn(drawingCanvas);
            // _balloon2 = _balloon1;
            balloon2TextBlock.Text = $"Created balloon 2: {_balloon2}";
        }

        private void compareButton_Click(object sender, RoutedEventArgs e)
        {
            if (_balloon1.Equals(_balloon2))
            {
                compareTextBlock.Text = "These balloons are equal!";
            }
            else
            {
                compareTextBlock.Text = "These balloons are not equal!";
            }
        }
    }
}
