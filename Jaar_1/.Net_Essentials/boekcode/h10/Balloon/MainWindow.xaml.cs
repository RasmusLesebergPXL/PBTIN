using System.Windows;

namespace BalloonApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Balloon _balloon;
        
        public MainWindow()
        {
            InitializeComponent();

            _balloon = new Balloon();
            _balloon.DisplayOn(drawingCanvas);
        }

        private void moveButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.MoveRight(20);
        }

        private void growButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.ChangeSize(20);
        }
    }
}
