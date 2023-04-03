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

namespace oef_3._1_Driehoek
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
            Line horizontal = new Line();
            horizontal.X1 = 20; horizontal.Y1 = 20;
            horizontal.X2 = 120; horizontal.Y2 = 20;
            horizontal.Stroke = new SolidColorBrush(Colors.Black);

            Line vertical = new Line();
            vertical.X1 = 20; vertical.Y1 = 20;
            vertical.X2 = 20; vertical.Y2 = 120;
            vertical.Stroke = new SolidColorBrush(Colors.Black);

            Line diagonal = new Line();
            diagonal.X1 = 120; diagonal.Y1 = 20;
            diagonal.X2 = 20; diagonal.Y2 = 120;
            diagonal.Stroke = new SolidColorBrush(Colors.Black);

            paperCanvas.Children.Add(vertical);
            paperCanvas.Children.Add(horizontal);
            paperCanvas.Children.Add(diagonal);
        }
    }
}
