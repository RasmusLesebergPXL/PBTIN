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

namespace oef_3._3_huis
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
            Rectangle frontside = new Rectangle();
            frontside.Width = 250;
            frontside.Height = 250;
            frontside.Margin = new Thickness(10, 150, 0, 0);
            frontside.Stroke = new SolidColorBrush(Colors.Black);

            Line roofLineleft = new Line();
            roofLineleft.X1 = 10; roofLineleft.Y1 = 150;
            roofLineleft.X2 = 135; roofLineleft.Y2 = 10;
            roofLineleft.Stroke = new SolidColorBrush(Colors.Black);

            Line roofLineRight = new Line();
            roofLineRight.X1 = 135; roofLineRight.Y1 = 10;
            roofLineRight.X2 = 260; roofLineRight.Y2 = 150;
            roofLineRight.Stroke = new SolidColorBrush(Colors.Black);

            Line roofLineSide = new Line();
            roofLineSide.X1 = 135; roofLineSide.Y1 = 10;
            roofLineSide.X2 = 300; roofLineSide.Y2 = 110;
            roofLineSide.Stroke = new SolidColorBrush(Colors.Black);

            Line wallSideBottomHorizontal = new Line();
            wallSideBottomHorizontal.X1 = 260; wallSideBottomHorizontal.Y1 = 400;
            wallSideBottomHorizontal.X2 = 300; wallSideBottomHorizontal.Y2 = 360;
            wallSideBottomHorizontal.Stroke = new SolidColorBrush(Colors.Black);

            Line wallSideTopHorizontal = new Line();
            wallSideTopHorizontal.X1 = 260; wallSideTopHorizontal.Y1 = 150;
            wallSideTopHorizontal.X2 = 300; wallSideTopHorizontal.Y2 = 110;
            wallSideTopHorizontal.Stroke = new SolidColorBrush(Colors.Black);

            Line wallSideVertical = new Line();
            wallSideVertical.X1 = 300; wallSideVertical.Y1 = 110;
            wallSideVertical.X2 = 300; wallSideVertical.Y2 = 360;
            wallSideVertical.Stroke = new SolidColorBrush(Colors.Black);

            Rectangle door = new Rectangle();
            door.Width = 60;
            door.Height = 120;
            door.Margin = new Thickness(180, 280, 0, 0);
            door.Stroke = new SolidColorBrush(Colors.Black);
            door.StrokeThickness = 3;

            Rectangle window = new Rectangle();
            window.Width = 60;
            window.Height = 60;
            window.Margin = new Thickness(60, 200, 0, 0);
            window.Stroke = new SolidColorBrush(Colors.Black);

            Line windowVertical = new Line();
            windowVertical.X1 = 90; windowVertical.Y1 = 200;
            windowVertical.X2 = 90; windowVertical.Y2 = 260;
            windowVertical.Stroke = new SolidColorBrush(Colors.Black);
            windowVertical.StrokeThickness = 4;

            Line windowHorizontal = new Line();
            windowHorizontal.X1 = 60; windowHorizontal.Y1 = 230;
            windowHorizontal.X2 = 120; windowHorizontal.Y2 = 230;
            windowHorizontal.Stroke = new SolidColorBrush(Colors.Black);
            windowHorizontal.StrokeThickness = 4;

            Ellipse doorknob = new Ellipse();
            doorknob.Width = 5;
            doorknob.Height = 5;
            doorknob.Margin = new Thickness(185, 340, 0, 0);
            doorknob.Fill = new SolidColorBrush(Colors.Red);
            doorknob.Stroke = new SolidColorBrush(Colors.Black);

            paperCanvas.Children.Add(frontside);
            paperCanvas.Children.Add(roofLineleft);
            paperCanvas.Children.Add(roofLineRight);
            paperCanvas.Children.Add(wallSideBottomHorizontal);
            paperCanvas.Children.Add(wallSideTopHorizontal);
            paperCanvas.Children.Add(wallSideVertical);
            paperCanvas.Children.Add(roofLineSide);
            paperCanvas.Children.Add(door);
            paperCanvas.Children.Add(window);
            paperCanvas.Children.Add(windowHorizontal);
            paperCanvas.Children.Add(windowVertical);
            paperCanvas.Children.Add(doorknob);
        }

 
    }
}
