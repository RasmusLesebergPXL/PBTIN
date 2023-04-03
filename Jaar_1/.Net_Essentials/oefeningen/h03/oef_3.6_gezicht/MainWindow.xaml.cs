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

namespace oef_3._6_gezicht
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

        private void Canvas_MouseMove(object sender, MouseEventArgs e)
        {
            xTextBox.Text = Convert.ToString(Convert.ToInt32(e.GetPosition(paperCanvas).X));
            yTextBox.Text = Convert.ToString(Convert.ToInt32(e.GetPosition(paperCanvas).Y));

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Ellipse omtrek = new Ellipse();
            omtrek.Width = 200;
            omtrek.Height = 250;
            omtrek.Stroke = new SolidColorBrush(Colors.Black);
            omtrek.Margin = new Thickness(83, 50, 0, 0);

            Ellipse oogEen = new Ellipse();
            oogEen.Width = 50;
            oogEen.Height = 30;
            oogEen.Stroke = new SolidColorBrush(Colors.Black);
            oogEen.Margin = new Thickness(110, 140, 0, 0);

            Ellipse oogTwee = new Ellipse();
            oogTwee.Width = 50;
            oogTwee.Height = 30;
            oogTwee.Stroke = new SolidColorBrush(Colors.Black);
            oogTwee.Margin = new Thickness(195, 140, 0, 0);

            Ellipse pupilEen = new Ellipse();
            pupilEen.Width = 20;
            pupilEen.Height = 20;
            pupilEen.Stroke = new SolidColorBrush(Colors.Black);
            pupilEen.Margin = new Thickness(125, 145, 0, 0);
            pupilEen.Fill = new SolidColorBrush(Colors.Black);

            Ellipse pupilTwee = new Ellipse();
            pupilTwee.Width = 20;
            pupilTwee.Height = 20;
            pupilTwee.Stroke = new SolidColorBrush(Colors.Black);
            pupilTwee.Margin = new Thickness(210, 145, 0, 0);
            pupilTwee.Fill = new SolidColorBrush(Colors.Black);

            Line wenkbrauwEen = new Line();
            wenkbrauwEen.X1 = 110; wenkbrauwEen.Y1 = 120;
            wenkbrauwEen.X2 = 170; wenkbrauwEen.Y2 = 140;
            wenkbrauwEen.Stroke = new SolidColorBrush(Colors.Black);
            wenkbrauwEen.StrokeThickness = 4;

            Line wenkbrauwTwee = new Line();
            wenkbrauwTwee.X1 = 260; wenkbrauwTwee.Y1 = 120;
            wenkbrauwTwee.X2 = 190; wenkbrauwTwee.Y2 = 140;
            wenkbrauwTwee.Stroke = new SolidColorBrush(Colors.Black);
            wenkbrauwTwee.StrokeThickness = 4;

            Line neusVertical = new Line();
            neusVertical.X1 = 180; neusVertical.Y1 = 170;
            neusVertical.X2 = 180; neusVertical.Y2 = 210;
            neusVertical.Stroke = new SolidColorBrush(Colors.Black);
            neusVertical.StrokeThickness = 2;

            Line neusHorizontal = new Line();
            neusHorizontal.X1 = 180; neusHorizontal.Y1 = 210;
            neusHorizontal.X2 = 165; neusHorizontal.Y2 = 195;
            neusHorizontal.Stroke = new SolidColorBrush(Colors.Black);
            neusHorizontal.StrokeThickness = 2;

            Line neusHorizontalTwee = new Line();
            neusHorizontalTwee.X1 = 180; neusHorizontalTwee.Y1 = 210;
            neusHorizontalTwee.X2 = 195; neusHorizontalTwee.Y2 = 195;
            neusHorizontalTwee.Stroke = new SolidColorBrush(Colors.Black);
            neusHorizontalTwee.StrokeThickness = 2;

            Rectangle mond = new Rectangle();
            mond.Width = 80;
            mond.Height = 30;
            mond.Margin = new Thickness(145, 240, 0, 0);
            mond.Stroke = new SolidColorBrush(Colors.Black);

            Rectangle tand1 = new Rectangle();
            tand1.Width = 20;
            tand1.Height = 15;
            tand1.Margin = new Thickness(145, 240, 0, 0);
            tand1.Stroke = new SolidColorBrush(Colors.Black);
            tand1.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand2 = new Rectangle();
            tand2.Width = 20;
            tand2.Height = 15;
            tand2.Margin = new Thickness(165, 240, 0, 0);
            tand2.Stroke = new SolidColorBrush(Colors.Black);
            tand2.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand3 = new Rectangle();
            tand3.Width = 20;
            tand3.Height = 15;
            tand3.Margin = new Thickness(185, 240, 0, 0);
            tand3.Stroke = new SolidColorBrush(Colors.Black);
            tand3.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand4 = new Rectangle();
            tand4.Width = 20;
            tand4.Height = 15;
            tand4.Margin = new Thickness(205, 240, 0, 0);
            tand4.Stroke = new SolidColorBrush(Colors.Black);
            tand4.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand5 = new Rectangle();
            tand5.Width = 20;
            tand5.Height = 15;
            tand5.Margin = new Thickness(145, 260, 0, 0);
            tand5.Stroke = new SolidColorBrush(Colors.Black);
            tand5.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand6 = new Rectangle();
            tand6.Width = 20;
            tand6.Height = 15;
            tand6.Margin = new Thickness(165, 260, 0, 0);
            tand6.Stroke = new SolidColorBrush(Colors.Black);
            tand6.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand7 = new Rectangle();
            tand7.Width = 20;
            tand7.Height = 15;
            tand7.Margin = new Thickness(185, 260, 0, 0);
            tand7.Stroke = new SolidColorBrush(Colors.Black);
            tand7.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Rectangle tand8 = new Rectangle();
            tand8.Width = 20;
            tand8.Height = 15;
            tand8.Margin = new Thickness(205, 260, 0, 0);
            tand8.Stroke = new SolidColorBrush(Colors.Black);
            tand8.Fill = new SolidColorBrush(Colors.LightGoldenrodYellow);

            Ellipse oorEen = new Ellipse();
            oorEen.Width = 20;
            oorEen.Height = 65;
            oorEen.Margin = new Thickness(70, 120, 0, 0);
            oorEen.Stroke = new SolidColorBrush(Colors.Black);
            oorEen.Fill = new SolidColorBrush(Colors.Black);

            Ellipse oorTwee = new Ellipse();
            oorTwee.Width = 20;
            oorTwee.Height = 65;
            oorTwee.Margin = new Thickness(270, 120, 0, 0);
            oorTwee.Stroke = new SolidColorBrush(Colors.Black);
            oorTwee.Fill = new SolidColorBrush(Colors.Black);

            Line haarEen = new Line();
            haarEen.X1 = 121; haarEen.Y1 = 78;
            haarEen.X2 = 50; haarEen.Y2 = 28;
            haarEen.Stroke = new SolidColorBrush(Colors.Black);
            haarEen.StrokeThickness = 4;

            Line haarTwee = new Line();
            haarTwee.X1 = 133; haarTwee.Y1 = 68;
            haarTwee.X2 = 90; haarTwee.Y2 = 28;
            haarTwee.Stroke = new SolidColorBrush(Colors.Black);
            haarTwee.StrokeThickness = 3;

            Line haarDrie = new Line();
            haarDrie.X1 = 152; haarDrie.Y1 = 56;
            haarDrie.X2 = 150; haarDrie.Y2 = 28;
            haarDrie.Stroke = new SolidColorBrush(Colors.Black);
            haarDrie.StrokeThickness = 2;

            Line haarVier = new Line();
            haarVier.X1 = 177; haarVier.Y1 = 51;
            haarVier.X2 = 177; haarVier.Y2 = 28;
            haarVier.Stroke = new SolidColorBrush(Colors.Black);
            haarVier.StrokeThickness = 4;

            Line haarVijf = new Line();
            haarVijf.X1 = 209; haarVijf.Y1 = 54;
            haarVijf.X2 = 240; haarVijf.Y2 = 28;
            haarVijf.Stroke = new SolidColorBrush(Colors.Black);
            haarVijf.StrokeThickness = 3;

            Line haarZes = new Line();
            haarZes.X1 = 231; haarZes.Y1 = 66;
            haarZes.X2 = 260; haarZes.Y2 = 28;
            haarZes.Stroke = new SolidColorBrush(Colors.Black);
            haarZes.StrokeThickness = 4;

            Line haarZeven = new Line();
            haarZeven.X1 = 248; haarZeven.Y1 = 80;
            haarZeven.X2 = 280; haarZeven.Y2 = 28;
            haarZeven.Stroke = new SolidColorBrush(Colors.Black);
            haarZeven.StrokeThickness = 3;


            paperCanvas.Children.Add(omtrek);
            paperCanvas.Children.Add(oogEen);
            paperCanvas.Children.Add(oogTwee);
            paperCanvas.Children.Add(pupilEen);
            paperCanvas.Children.Add(pupilTwee);
            paperCanvas.Children.Add(wenkbrauwEen);
            paperCanvas.Children.Add(wenkbrauwTwee);
            paperCanvas.Children.Add(neusVertical);
            paperCanvas.Children.Add(neusHorizontal);
            paperCanvas.Children.Add(neusHorizontalTwee);
            paperCanvas.Children.Add(mond);
            paperCanvas.Children.Add(tand1);
            paperCanvas.Children.Add(tand2);
            paperCanvas.Children.Add(tand3);
            paperCanvas.Children.Add(tand4);
            paperCanvas.Children.Add(tand5);
            paperCanvas.Children.Add(tand6);
            paperCanvas.Children.Add(tand7);
            paperCanvas.Children.Add(tand8);
            paperCanvas.Children.Add(oorEen);
            paperCanvas.Children.Add(oorTwee);
            paperCanvas.Children.Add(haarEen);
            paperCanvas.Children.Add(haarTwee);
            paperCanvas.Children.Add(haarDrie);
            paperCanvas.Children.Add(haarVier);
            paperCanvas.Children.Add(haarVijf);
            paperCanvas.Children.Add(haarZes);
            paperCanvas.Children.Add(haarZeven);

              
        }
    }
}
