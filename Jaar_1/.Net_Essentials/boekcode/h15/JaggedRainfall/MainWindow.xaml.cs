using System;
using System.Windows;

namespace JaggedRainfall
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int[][] _rainData;
        
        public MainWindow()
        {
            InitializeComponent();
            // of alternatief
            _rainData = new int[3][];
            _rainData[0] = new int[3];
            _rainData[1] = new int[4];
            _rainData[2] = new int[7];

            // of alternatief
            _rainData[0] = new int[] { 10, 7, 3 };
            _rainData[1] = new int[] { 12, 3, 5, 7 };
            _rainData[2] = new int[] { 8, 5, 2, 1, 1, 4, 7 };

            Display();
        }

        private void Display()
        {
            dataTextBox.Clear();
            for (int locationIndex = 0; locationIndex < _rainData.Length; locationIndex++)
            {
                for (int dayNumber = 0; dayNumber < _rainData[locationIndex].Length; dayNumber++)
                {
                    dataTextBox.AppendText($"{_rainData[locationIndex][dayNumber]}\t");
                }
                dataTextBox.AppendText(Environment.NewLine);
            }
        }

        private void changeButton_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
