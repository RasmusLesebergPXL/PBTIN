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
        }

        private void balloon2Button_Click(object sender, RoutedEventArgs e)
        {
            //_balloon2 = new Balloon();
            //_balloon2.DisplayOn(drawingCanvas);
            _balloon2 = _balloon1;
        }

        private void compareButton_Click(object sender, RoutedEventArgs e)
        {
            if (_balloon1.Equals(_balloon2))
            {
                compareTexBlock.Text = "These balloons are equal!";
            }
            else
            {
                compareTexBlock.Text = "These balloons are not equal!";
            }
            balloon1TexBlock.Text = _balloon1.ToString();
            //balloon1TexBlock.Text = _balloon1.GetType().ToString();

            balloon2TextBlock.Text = _balloon2.ToString();
        }
    }
}
