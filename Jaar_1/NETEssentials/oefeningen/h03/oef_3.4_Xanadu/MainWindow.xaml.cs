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

namespace oef_3._4_Xanadu
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
            Rectangle rectangleOne = new Rectangle();
            rectangleOne.Width = 100;
            rectangleOne.Height = 25;
            rectangleOne.Margin = new Thickness(10, 10, 0, 0);
            rectangleOne.Fill = new SolidColorBrush(Colors.Lavender);
            rectangleOne.Stroke = new SolidColorBrush(Colors.Black);

            TextBox een = new TextBox();
            een.AppendText("2009");
            een.Background = new SolidColorBrush(Colors.Lavender);
            een.Margin = new Thickness(10, 10, 0, 0);

            Rectangle rectangleTwo = new Rectangle();
            rectangleTwo.Width = 100;
            rectangleTwo.Height = 25;
            rectangleTwo.Margin = new Thickness(10, 35, 0, 0);
            rectangleTwo.Fill = new SolidColorBrush(Colors.LightCoral);
            rectangleTwo.Stroke = new SolidColorBrush(Colors.Black);

            TextBox twee = new TextBox();
            twee.AppendText("2010");
            twee.Background = new SolidColorBrush(Colors.LightCoral);
            twee.Margin = new Thickness(10, 35, 0, 0);

            Rectangle rectangleThree = new Rectangle();
            rectangleThree.Width = 100;
            rectangleThree.Height = 25;
            rectangleThree.Margin = new Thickness(10, 60, 0, 0);
            rectangleThree.Fill = new SolidColorBrush(Colors.LightCyan);
            rectangleThree.Stroke = new SolidColorBrush(Colors.Black);

            TextBox drie = new TextBox();
            drie.AppendText("2011");
            drie.Background = new SolidColorBrush(Colors.LightCyan);
            drie.Margin = new Thickness(10, 60, 0, 0);

            Rectangle rectangleFour = new Rectangle();
            rectangleFour.Width = 100;
            rectangleFour.Height = 25;
            rectangleFour.Margin = new Thickness(10, 85, 0, 0);
            rectangleFour.Fill = new SolidColorBrush(Colors.LightPink);
            rectangleFour.Stroke = new SolidColorBrush(Colors.Black);

            TextBox vier = new TextBox();
            vier.AppendText("2012");
            vier.Background = new SolidColorBrush(Colors.LightPink);
            vier.Margin = new Thickness(10, 85, 0, 0);

            Rectangle rectangleFive = new Rectangle();
            rectangleFive.Width = 100;
            rectangleFive.Height = 25;
            rectangleFive.Margin = new Thickness(110, 10, 0, 0);
            rectangleFive.Fill = new SolidColorBrush(Colors.LightSalmon);
            rectangleFive.Stroke = new SolidColorBrush(Colors.Black);

            TextBox vijf = new TextBox();
            vijf.AppendText("150 cm");
            vijf.Background = new SolidColorBrush(Colors.LightSalmon);
            vijf.Margin = new Thickness(110, 10, 0, 0);

            Rectangle rectangleSix = new Rectangle();
            rectangleSix.Width = 100;
            rectangleSix.Height = 25;
            rectangleSix.Margin = new Thickness(110, 35, 0, 0);
            rectangleSix.Fill = new SolidColorBrush(Colors.LightSeaGreen);
            rectangleSix.Stroke = new SolidColorBrush(Colors.Black);

            TextBox zes = new TextBox();
            zes.AppendText("175 cm");
            zes.Background = new SolidColorBrush(Colors.LightSeaGreen);
            zes.Margin = new Thickness(110, 35, 0, 0);

            Rectangle rectangleSeven = new Rectangle();
            rectangleSeven.Width = 100;
            rectangleSeven.Height = 25;
            rectangleSeven.Margin = new Thickness(110, 60, 0, 0);
            rectangleSeven.Fill = new SolidColorBrush(Colors.LightSkyBlue);
            rectangleSeven.Stroke = new SolidColorBrush(Colors.Black);

            TextBox zeven = new TextBox();
            zeven.AppendText("120 cm");
            zeven.Background = new SolidColorBrush(Colors.LightSkyBlue);
            zeven.Margin = new Thickness(110, 60, 0, 0);

            Rectangle rectangleEight = new Rectangle();
            rectangleEight.Width = 100;
            rectangleEight.Height = 25;
            rectangleEight.Margin = new Thickness(110, 85, 0, 0);
            rectangleEight.Fill = new SolidColorBrush(Colors.Lavender);
            rectangleEight.Stroke = new SolidColorBrush(Colors.Black);

            TextBox acht = new TextBox();
            acht.AppendText("130 cm");
            acht.Background = new SolidColorBrush(Colors.Lavender);
            acht.Margin = new Thickness(110, 85, 0, 0);

            paperCanvas.Children.Add(rectangleOne);
            paperCanvas.Children.Add(rectangleTwo);
            paperCanvas.Children.Add(rectangleThree);
            paperCanvas.Children.Add(rectangleFour);
            paperCanvas.Children.Add(rectangleFive);
            paperCanvas.Children.Add(rectangleSix);
            paperCanvas.Children.Add(rectangleSeven);
            paperCanvas.Children.Add(rectangleEight);
            paperCanvas.Children.Add(een);
            paperCanvas.Children.Add(twee);
            paperCanvas.Children.Add(drie);
            paperCanvas.Children.Add(vier);
            paperCanvas.Children.Add(vijf);
            paperCanvas.Children.Add(zes);
            paperCanvas.Children.Add(zeven);
            paperCanvas.Children.Add(acht);
        }
    }
}
