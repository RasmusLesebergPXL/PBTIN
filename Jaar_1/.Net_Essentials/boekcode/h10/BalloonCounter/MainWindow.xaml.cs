using System.Windows;

namespace BalloonCounter
{
    /// <summary>
    /// De code in commentaar is geen goede oplossing om ballonnen te tellen.
    /// Het is beter om een static variabele op de klasse Balloon te introduceren.
    /// </summary>
    public partial class MainWindow : Window
    {
        private Balloon _balloon;
        // private int _count;

        public MainWindow()
        {
            InitializeComponent();
            // _count = 0;
        }

        private void createButton_Click(object sender, RoutedEventArgs e)
        {
            _balloon = new Balloon();
            //_count++;
            _balloon.DisplayOn(drawingCanvas);
            //countTextBlock.Text = $"Number of balloons created: {_count}";
            countTextBlock.Text = $"Number of balloons created: {Balloon.Count}";
        }
    }
}
