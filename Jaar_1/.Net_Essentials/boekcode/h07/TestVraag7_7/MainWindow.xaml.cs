using System;
using System.Windows;

namespace TestVraag7_7
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

        void volumeSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
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
