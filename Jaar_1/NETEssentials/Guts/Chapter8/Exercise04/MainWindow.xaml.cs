using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Exercise04
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            DrawTrap();
        }

        private void DrawTrap()
        {
            var brush = new SolidColorBrush(Colors.Black);

            double y = 5;
            for (int i = 1; i <= 6; i++)
            {
                double x = 5;
                for (int j = 1; j <= i; j++)
                {
                    DrawRectangle(paperCanvas, brush, x, y, 15, 15);
                    x += 25;
                }
                y += 25;
            }
        }

        private void DrawRectangle(Canvas paperCanvas, SolidColorBrush brush, 
                                   double x, double y, int width, int height)
        {
            Rectangle rectangle = new Rectangle()
            {
                Width = width,
                Height = height,
                Margin = new Thickness(x, y, 0, 0),
                Stroke = brush
            };
            paperCanvas.Children.Add(rectangle);
        }
    }
}
