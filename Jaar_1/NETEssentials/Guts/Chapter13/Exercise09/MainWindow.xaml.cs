using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Exercise09
{
    public partial class MainWindow : Window
    {
        private SolidColorBrush _background;
        public MainWindow()
        {
            InitializeComponent();

            _background = new SolidColorBrush();

        }

        private void comboBoxColor_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            string color = ((ComboBoxItem)comboBoxColor.SelectedItem).Content.ToString();
            SolidColorBrush colorConverted = (SolidColorBrush)new BrushConverter().ConvertFromString(color);
            _background = colorConverted;
            colorLabel.Background = _background;
        }
    }
}
