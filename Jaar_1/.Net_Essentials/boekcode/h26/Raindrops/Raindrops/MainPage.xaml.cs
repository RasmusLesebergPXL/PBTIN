using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;
using Windows.UI.Xaml.Shapes;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace Raindrops
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private Random randomNumber = new Random();
        private double x, y, size;
        private SolidColorBrush brush;
        private DispatcherTimer timer = new DispatcherTimer();

        public MainPage()
        {
            this.InitializeComponent();

            gapTextBlock.Text = $"{gapSlider.Value} ms gap";
            brush = new SolidColorBrush(Colors.Blue);
            timer.Interval = TimeSpan.FromMilliseconds(gapSlider.Value);
            timer.Tick += timer_Tick;

            gapSlider.ValueChanged += gapSlider_ValueChange;
        }

        private void startButton_Click(object sender, RoutedEventArgs e)
        {
            timer.Start();
        }

        private void stopButton_Click(object sender, RoutedEventArgs e)
        {
            timer.Stop();
        }

        private void clearButton_Click(object sender, RoutedEventArgs e)
        {
            paperCanvas.Children.Clear();
        }

        private void timer_Tick(object sender, object e)
        {
            x = randomNumber.Next(0, Convert.ToInt32(paperCanvas.ActualWidth));
            y = randomNumber.Next(0, Convert.ToInt32(paperCanvas.ActualHeight));
            size = randomNumber.Next(1, 40);

            Ellipse ellipse = new Ellipse
            {
                Width = size,
                Height = size,
                Stroke = brush,
                Fill = brush,
                Margin = new Thickness(x, y, 0, 0)
            };
            paperCanvas.Children.Add(ellipse);

            // set new interval for timer
            timer.Stop();
            int ms = randomNumber.Next(1, Convert.ToInt32(gapSlider.Value));
            timer.Interval = TimeSpan.FromMilliseconds(ms);
            timer.Start();
        }

        private void gapSlider_ValueChange(object sender, RangeBaseValueChangedEventArgs e)
        {
            int timeGap = Convert.ToInt32(gapSlider.Value);
            gapTextBlock.Text = $"{timeGap} ms gap";
        }
    }
}
