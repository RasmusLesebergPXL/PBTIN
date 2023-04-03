using System;
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
            radiusSlider.Value = _balloon.Radius;
            radiusLabel.Content = Convert.ToString(_balloon.Radius);
            _balloon.DisplayOn(balloonCanvas);
        }

        private void upButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.MoveUp(5);
        }

        private void downButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.MoveDown(5);
        }

        private void radiusSlider_ValueChanged(object sender,
                              RoutedPropertyChangedEventArgs<double> e)
        {
            _balloon.Radius = Convert.ToInt32(radiusSlider.Value);
            radiusLabel.Content = Convert.ToString(_balloon.Radius);
        }
    }
}
