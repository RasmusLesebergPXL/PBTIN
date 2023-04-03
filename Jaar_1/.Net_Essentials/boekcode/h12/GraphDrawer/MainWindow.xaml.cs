using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace GraphDrawer
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private double _a, _b, _c, _d;
        private SolidColorBrush _brush = new SolidColorBrush(Colors.Black);

        public MainWindow()
        {
            InitializeComponent();
            
            aSlider.ValueChanged += Slider_ValueChanged;
            bSlider.ValueChanged += Slider_ValueChanged;
            cSlider.ValueChanged += Slider_ValueChanged;
            dSlider.ValueChanged += Slider_ValueChanged;
        }

        private void Slider_ValueChanged(object sender,
                    RoutedPropertyChangedEventArgs<double> e)
        {
 	        _a = aSlider.Value;
            aTextBlock.Text = $"a = {_a:0}";
            _b = bSlider.Value;
            bTextBlock.Text = $"b = {_b:0}";
            _c = cSlider.Value;
            cTextBlock.Text = $"c = {_c:0}";
            _d = dSlider.Value;
            dTextBlock.Text = $"d = {_d:0}";
            graphCanvas.Children.Clear();
            Draw();
        }

        private void Draw()
        {
            double x, y, nextX, nextY;
            double xPixel, yPixel, nextXPixel, nextYPixel;

            for (xPixel = 0; xPixel <= graphCanvas.Width; xPixel++)
            {
                x = ScaleX(xPixel);
                y = TheFunction(x);
                yPixel = ScaleY(y);
                nextXPixel = xPixel + 1;
                nextX = ScaleX(nextXPixel);
                nextY = TheFunction(nextX);
                nextYPixel = ScaleY(nextY);
                DrawLine(xPixel, yPixel, nextXPixel, nextYPixel);
            }
        }

        private double TheFunction(double x)
        {
            return _a * Math.Pow(x, 3) + _b * Math.Pow(x, 2) + _c * x + _d;
        }

        private double ScaleX(double xPixel)
        {
            const double XStart = -5;
            const double XEnd = 5;
            double xScale = graphCanvas.Width / (XEnd - XStart);
            return (xPixel - (graphCanvas.Width / 2)) / xScale;
        }

        private double ScaleY(double y)
        {
            const double YStart = -5;
            const double YEnd = 5;
            double yScale = graphCanvas.Height / (YEnd - YStart);
            double pixelCoord = (-y * yScale) +
                                (graphCanvas.Height / 2);
            return pixelCoord;
        }

        private void DrawLine(double x1, double y1,
                              double x2, double y2)
        {
            Line line = new Line
            {
                X1 = x1,
                Y1 = y1,
                X2 = x2,
                Y2 = y2,
                Stroke = _brush
            };
            graphCanvas.Children.Add(line);
        }
    }
}
