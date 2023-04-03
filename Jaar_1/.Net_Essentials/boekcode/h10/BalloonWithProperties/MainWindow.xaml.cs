using System;
using System.Windows;

namespace BalloonWithProperties
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Balloon _balloon;
        
        public MainWindow()
        {
            InitializeComponent();

            _balloon = new Balloon();
            _balloon.DisplayOn(drawingCanvas);
        }

        private void moveButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.MoveRight(20);
        }

        private void growButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.ChangeSize(20);
        }

        private void displayXButton_Click(object sender, RoutedEventArgs e)
        {
            xCoordTextBox.Text = Convert.ToString(_balloon.XCoord);
        }

        private void changeXButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon.XCoord = Convert.ToInt32(xCoordTextBox.Text);
        }
    }
}
