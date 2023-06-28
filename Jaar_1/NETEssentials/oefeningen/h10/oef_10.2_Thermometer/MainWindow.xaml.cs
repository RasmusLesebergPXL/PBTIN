using System;
using System.Windows;

namespace oef_10._2_Thermometer
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Thermometer _thermometer;
        public MainWindow()
        {
            InitializeComponent();

            _thermometer = new Thermometer();
        }

        private void temperatureSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            int change = Convert.ToInt32(temperatureSlider.Value);
            _thermometer.SetTemperature(change);


            temperatureTextBlock.Text = Convert.ToString(change);
            maxTextBlock.Text = Convert.ToString(_thermometer.GetMax());
            minTextBlock.Text = Convert.ToString(_thermometer.GetMin());
        }

        private void ResetButton_Click(object sender, RoutedEventArgs e)
        {
            _thermometer.Reset();
            temperatureSlider.Value = 0;
        }
    }
}
