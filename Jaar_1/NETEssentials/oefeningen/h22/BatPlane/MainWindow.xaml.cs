using System.Windows;

namespace ExampleInterface
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Airplane _airplane;
        private Bat _bat;
        public MainWindow()
        {
            InitializeComponent();
            _airplane = new Airplane(220, "BXL123");
            _airplane.DisplayOn(canvas);
            _bat = new Bat();
            _bat.DisplayOn(canvas);
        }

        private void flyButton_Click(object sender, RoutedEventArgs e)
        {
            _airplane.Fly();
            _bat.Fly();
        }

        private void landButton_Click(object sender, RoutedEventArgs e)
        {
            _airplane.Land();
            _bat.Land();
        }

        private void soundButton_Click(object sender, RoutedEventArgs e)
        {
            _bat.MakeSound();
        }
    }
}