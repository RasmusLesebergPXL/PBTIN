using System;
using System.Windows;

namespace Amplifier
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int _max = 0;
        
        public MainWindow()
        {
            InitializeComponent();

            volumeSlider.ValueChanged += volumeSlider_ValueChanged;
        }

        private void volumeSlider_ValueChanged(object sender,
                            RoutedPropertyChangedEventArgs<double> e)
        {
            int volume = Convert.ToInt32(volumeSlider.Value);
            if (volume > _max)
            {
                _max = volume;
            }
            messageLabel.Content = $"maximum value is {_max}";
        }   
    }
}
