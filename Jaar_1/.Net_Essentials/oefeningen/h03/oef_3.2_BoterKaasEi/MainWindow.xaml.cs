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

namespace oef_3._2_BoterKaasEi
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

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Rectangle outerRectangle = new Rectangle();
            outerRectangle.Width = 150;
            outerRectangle.Height = 60;
            outerRectangle.Margin = new Thickness(10, 10, 0, 0);            
            outerRectangle.Stroke = new SolidColorBrush(Colors.Green);
           
            Line horizontalEen = new Line();
            horizontalEen.X1 = 10; horizontalEen.Y1 = 30;
            horizontalEen.X2 = 160; horizontalEen.Y2 = 30;
            horizontalEen.Stroke = new SolidColorBrush(Colors.Green);

            Line horizontalTwee = new Line();
            horizontalTwee.X1 = 10; horizontalTwee.Y1 = 50;
            horizontalTwee.X2 = 160; horizontalTwee.Y2 = 50;
            horizontalTwee.Stroke = new SolidColorBrush(Colors.Green);

            Line verticalEen = new Line();
            verticalEen.X1 = 60; verticalEen.Y1 = 10;
            verticalEen.X2 = 60; verticalEen.Y2 = 70;
            verticalEen.Stroke = new SolidColorBrush(Colors.Green);

            Line verticalTwee = new Line();
            verticalTwee.X1 = 110; verticalTwee.Y1 = 10;
            verticalTwee.X2 = 110; verticalTwee.Y2 = 70;
            verticalTwee.Stroke = new SolidColorBrush(Colors.Green);

            paperCanvas.Children.Add(outerRectangle);
            paperCanvas.Children.Add(horizontalEen);
            paperCanvas.Children.Add(horizontalTwee);
            paperCanvas.Children.Add(verticalEen);
            paperCanvas.Children.Add(verticalTwee);
        }
    }
}
