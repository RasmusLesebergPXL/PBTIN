using System.Windows;

namespace SphereAndBubble
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Sphere _sphere;
        private Bubble _bubble;
        private Ball _ball;
        
        public MainWindow()
        {
            InitializeComponent();
        }

        private void sphereButton_Click(object sender, RoutedEventArgs e)
        {
            if (_sphere == null)
            {
                _sphere = new Sphere();
                _sphere.CreateEllipse(paperCanvas);
            }
            else
            {
                _sphere.X = 0;
            }
        }

        private void bubbleButton_Click(object sender, RoutedEventArgs e)
        {
            if (_bubble == null)
            {
                _bubble = new Bubble();
                _bubble.CreateEllipse(paperCanvas);
                _bubble.Size = 5;
            }
            else
            {
                _bubble.MoveVertical(5);
            }
        }

        private void ballButton_Click(object sender, RoutedEventArgs e)
        {
            if (_ball == null)
            {
                _ball = new Ball();
                _ball.CreateEllipse(paperCanvas);
            }
            else
            {
                _ball.MoveRight(5);
            }
        }
    }
}
