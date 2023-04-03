using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Oval_Shape
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Ellipse _ellipse;

        public MainWindow()
        {
            InitializeComponent();
            horizontalSlider.ValueChanged += HorizontalSlider_ValueChanged;

            verticalSlider.Minimum = 0;
            verticalSlider.Maximum = paperCanvas.Height;

            horizontalSlider.Minimum = 0;
            horizontalSlider.Maximum = paperCanvas.Width;

            verticalLabel.Content = Convert.ToString(verticalSlider.Value);
            horizontalLabel.Content = Convert.ToString(horizontalSlider.Value);

            CreateEllipse();
        }

        private void verticalSlider_ValueChanged(object sender,
                                    RoutedPropertyChangedEventArgs<double> e)
        {
            int vertical = Convert.ToInt32(verticalSlider.Value);
            verticalLabel.Content = Convert.ToString(vertical);
            UpdateEllipse();
        }

        private void HorizontalSlider_ValueChanged(object sender,
                                      RoutedPropertyChangedEventArgs<double> e)
        {
            int horizontal = Convert.ToInt32(horizontalSlider.Value);
            horizontalLabel.Content = Convert.ToString(horizontal);
            UpdateEllipse();
        }

        private void CreateEllipse()
        {
            //_ellipse = new Ellipse();
            //_ellipse.Width = horizSlider.Value;
            //_ellipse.Height = vertSlider.Value;
            //_ellipse.Stroke = new SolidColorBrush(Colors.Blue);
            //_ellipse.Fill = new SolidColorBrush(Colors.Blue);
            //_ellipse.Margin = new Thickness(0, 0, 0, 0);
            _ellipse = new Ellipse()
            {
                Width = horizontalSlider.Value,
                Height = verticalSlider.Value,
                Stroke = new SolidColorBrush(Colors.Blue),
                Fill = new SolidColorBrush(Colors.Blue),
                Margin = new Thickness(0, 0, 0, 0)
            };
            paperCanvas.Children.Add(_ellipse);
        }

        private void UpdateEllipse()
        {
            _ellipse.Width = horizontalSlider.Value;
            _ellipse.Height = verticalSlider.Value; 
        }
    }
}
