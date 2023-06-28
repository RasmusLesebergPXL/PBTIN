using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace oef_5._4_Cirkel
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

        private void drawButton_Click(object sender, RoutedEventArgs e)
        {
            int xPositie = Convert.ToInt32(middelPuntXTextBox.Text);
            int yPositie = Convert.ToInt32(middelPuntYTextBox.Text);
            int straal = Convert.ToInt32(straalTextBox.Text);
            SolidColorBrush brush = new SolidColorBrush(Colors.White);
            DrawCircle(paperCanvas, brush, xPositie, yPositie, straal);
        }
    

        private void DrawCircle(Canvas drawArea,
                            SolidColorBrush brush,
                            double xCentre, 
                            double yCentre, 
                            double radius)
        {
            Ellipse myCircle = new Ellipse();
            {
                myCircle.Width = radius * 2;
                myCircle.Height = radius * 2;
                myCircle.Stroke = brush;
                myCircle.StrokeThickness = 6;
                myCircle.Margin = new Thickness(xCentre - radius, yCentre - radius, 0, 0);
            };
            drawArea.Children.Add(myCircle);
        }
}
}
