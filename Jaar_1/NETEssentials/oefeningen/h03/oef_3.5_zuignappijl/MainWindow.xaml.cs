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

namespace oef_3._5_zuignappijl
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
            Ellipse ellipseEen = new Ellipse();
            ellipseEen.Width = 30;
            ellipseEen.Height = 30;
            ellipseEen.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseEen.Margin = new Thickness(10, 10, 0, 0);
            ellipseEen.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseTwee = new Ellipse();
            ellipseTwee.Width = 30;
            ellipseTwee.Height = 30;
            ellipseTwee.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseTwee.Margin = new Thickness(40, 40, 0, 0);
            ellipseTwee.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseDrie = new Ellipse();
            ellipseDrie.Width = 30;
            ellipseDrie.Height = 30;
            ellipseDrie.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseDrie.Margin = new Thickness(70, 70, 0, 0);
            ellipseDrie.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseVier = new Ellipse();
            ellipseVier.Width = 30;
            ellipseVier.Height = 30;
            ellipseVier.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseVier.Margin = new Thickness(100, 100, 0, 0);
            ellipseVier.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseVijf = new Ellipse();
            ellipseVijf.Width = 30;
            ellipseVijf.Height = 30;
            ellipseVijf.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseVijf.Margin = new Thickness(20, 50, 0, 0);
            ellipseVijf.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseZes = new Ellipse();
            ellipseZes.Width = 30;
            ellipseZes.Height = 30;
            ellipseZes.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseZes.Margin = new Thickness(40, 80, 0, 0);
            ellipseZes.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseZeven = new Ellipse();
            ellipseZeven.Width = 30;
            ellipseZeven.Height = 30;
            ellipseZeven.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseZeven.Margin = new Thickness(140, 120, 0, 0);
            ellipseZeven.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseAcht = new Ellipse();
            ellipseAcht.Width = 30;
            ellipseAcht.Height = 30;
            ellipseAcht.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseAcht.Margin = new Thickness(130, 40, 0, 0);
            ellipseAcht.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseNegen = new Ellipse();
            ellipseNegen.Width = 30;
            ellipseNegen.Height = 30;
            ellipseNegen.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseNegen.Margin = new Thickness(80, 90, 0, 0);
            ellipseNegen.Stroke = new SolidColorBrush(Colors.Black);

            Ellipse ellipseTien = new Ellipse();
            ellipseTien.Width = 30;
            ellipseTien.Height = 30;
            ellipseTien.Fill = new SolidColorBrush(Colors.LightSalmon);
            ellipseTien.Margin = new Thickness(20, 90, 0, 0);
            ellipseTien.Stroke = new SolidColorBrush(Colors.Black);

            paperCanvas.Children.Add(ellipseEen);
            paperCanvas.Children.Add(ellipseTwee);
            paperCanvas.Children.Add(ellipseDrie);
            paperCanvas.Children.Add(ellipseVier);
            paperCanvas.Children.Add(ellipseVijf);
            paperCanvas.Children.Add(ellipseZes);
            paperCanvas.Children.Add(ellipseZeven);
            paperCanvas.Children.Add(ellipseAcht);
            paperCanvas.Children.Add(ellipseNegen);
            paperCanvas.Children.Add(ellipseTien);

           
        }
    }
}
