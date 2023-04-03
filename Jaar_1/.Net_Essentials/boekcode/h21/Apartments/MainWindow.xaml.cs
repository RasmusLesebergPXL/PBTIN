using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Apartments
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

        private void DrawFlats(int numberOfFloors, int numberOfFlats)
        {
            apartmentsCanvas.Children.Clear();
            var brush = new SolidColorBrush(Colors.Black);

            double y = 5;
            for (int floor = 0; floor < numberOfFloors; floor++)
            {
                double x = 5;
                for (int flat = 0; flat < numberOfFlats; flat++)
                {
                    DrawRectangle(apartmentsCanvas, brush, x, y, 20, 10);
                    x = x + 25;
                }
                y = y + 20;
            }
        }

        private void DrawFlats2(int numberOfFloors, int numberOfFlats)
        {
            apartmentsCanvas.Children.Clear();
            var brush = new SolidColorBrush(Colors.Black);

            double y = 5;
            for (int floor = 0; floor < numberOfFloors; floor++)
            {
                DrawFloor(numberOfFlats, y, brush);
                y = y + 20;
            }
        }

        private void DrawFloor(int numberOfFlats, double y, SolidColorBrush brush)
        {
            double x = 5;
            for (int flat = 0; flat < numberOfFlats; flat++)
            {
                DrawRectangle(apartmentsCanvas, brush, x, y, 20, 10);
                x = x + 25;
            }
        }

        

        private void DrawRectangle(Canvas paperCanvas, SolidColorBrush brush, double x, double y, double width, double height)
        {
            var rectangle = new Rectangle()
            {
                Width = width,
                Height = height,
                Margin = new Thickness(x, y, 0, 0),
                Stroke = brush
            };
            paperCanvas.Children.Add(rectangle);
        }

        private void apartmentsCanvas_MouseUp(object sender, MouseButtonEventArgs e)
        {
            DrawFlats2(7, 8);
        }
    }
}
