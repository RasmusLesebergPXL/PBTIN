using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace BalloonWithDelegate
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Balloon _balloon;
        private Ellipse _ellipse;

        public MainWindow()
        {
            InitializeComponent();

            CreateEllipse();
            _balloon = new Balloon();
            _balloon.Display = new BalloonDisplayer(Redraw);
            _balloon.Initialize(50, 50, 20);
        }

        private void Redraw(int x, int y, int diameter)
        {
            _ellipse.Margin = new Thickness(x, y, 0, 0);
            _ellipse.Width = diameter;
            _ellipse.Height = diameter;
        }

        private void CreateEllipse()
        {
            _ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Blue),
                StrokeThickness = 2
            };

            drawingCanvas.Children.Add(_ellipse);
        }
        
        private void moveButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.MoveRight(20);
        }

        private void growButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.ChangeSize(20);
        }

        private void displayXButton_Click(object sender, RoutedEventArgs e)
        {
            xCoordTextBox.Text = Convert.ToString(_balloon.XCoord);
        }

        private void changeXButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.XCoord = Convert.ToInt32(xCoordTextBox.Text);
        }
    }
}
