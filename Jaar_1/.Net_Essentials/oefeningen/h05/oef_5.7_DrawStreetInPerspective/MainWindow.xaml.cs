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

namespace oef_5._7_DrawStreetInPerspective
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
            DrawStreetInPerspective();
        }

        private void DrawStreetInPerspective()
        {
            SolidColorBrush blackBrush = new SolidColorBrush(Colors.Black);
            double scaleFactor = 0.2;
            DrawHouse(paperCanvas, blackBrush, 10, 90, 50, 50);
            DrawHouse(paperCanvas, blackBrush, 80, 90,
                      50 - 50 * scaleFactor, 50 - 50 * scaleFactor);
            scaleFactor += 0.2;
            DrawHouse(paperCanvas, blackBrush, 140, 90,
                      50 - 50 * scaleFactor, 50 - 50 * scaleFactor);
            scaleFactor += 0.2;
            DrawHouse(paperCanvas, blackBrush, 190, 90,
                      50 - 50 * scaleFactor, 50 - 50 * scaleFactor);
        }

        private void DrawHouse(Canvas drawingArea,
                               SolidColorBrush brushToUse,
                               double topRoofX,
                               double topRoofY,
                               double width,
                               double height)
        {
            DrawTriangle(drawingArea, brushToUse, topRoofX,
                            topRoofY, width, height);
            DrawRectangle(drawingArea, brushToUse, topRoofX,
                            topRoofY + height, width, height);
        }

        private void DrawTriangle(Canvas drawingArea,
                                  SolidColorBrush brushToUse,
                                  double topX,
                                  double topY,
                                  double width,
                                  double height)
        {
            Line line1 = new Line();
            line1.Stroke = brushToUse;
            line1.X1 = topX; line1.Y1 = topY;
            line1.X2 = topX; line1.Y2 = topY + height;

            Line line2 = new Line();
            line2.Stroke = brushToUse;
            line2.X1 = topX + height; line2.Y1 = topY + height;
            line2.X2 = topX + height; line2.Y2 = topY + width;

            Line line3 = new Line();
            line3.Stroke = brushToUse;
            line3.X1 = topX; line3.Y1 = topY;
            line3.X2 = topX + width; line3.Y2 = topY + height;

            drawingArea.Children.Add(line1);
            drawingArea.Children.Add(line2);
            drawingArea.Children.Add(line3);
        }

        private void DrawRectangle(Canvas drawingArea,
                                   SolidColorBrush brushToUse,
                                   double topLeftX,
                                   double topLeftY,
                                   double width,
                                   double height)
        {
            Rectangle aRectangle = new Rectangle();
            {
                aRectangle.Width = width;
                aRectangle.Height = height;
                aRectangle.Margin = new Thickness(topLeftX, topLeftY, 0, 0);
                aRectangle.Stroke = brushToUse;
            };
            drawingArea.Children.Add(aRectangle);
        }
    }
}
