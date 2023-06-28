using System;
using System.Windows;

namespace Game
{
    public partial class StartWindow : Window
    {
        private int _countRows;
        private int _countColumns;

        public StartWindow()
        {
            InitializeComponent();
        }


        private void AnimalListBox_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            // ToDo open the GameWindow. Make sure you give the right arguments in your constructor
            if (_countColumns == 0 || _countRows == 0)
            {
                MessageBox.Show("Gelieve de grootte van het spel in te stellen", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
            else if (nameTextBox.Text == null || nameTextBox.Text == "")
            {
                MessageBox.Show("Gelieve uw naam in te vullen", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
            else if (animalListBox.SelectedItem == null)
            {
                MessageBox.Show("Kies een dier", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
            } else
            {
                string name = nameTextBox.Text;
                string animal = Convert.ToString(animalListBox.SelectedItem);
                Window window = new GameWindow(_countRows, _countColumns, animal, name);
                window.ShowDialog();
                Reset();
            }
        }
        private void GameRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            // ToDo give _countRows and _countColumns the right value.
            if (smallGameRadioButton.IsChecked == true)
            {
                _countRows = 8;
                _countColumns = 10;
            } else if (gameRadioButton.IsChecked == true)
            {
                _countRows = 12;
                _countColumns = 12;
            } else if (largeRadioButton.IsChecked == true)
            {
                _countRows = 14;
                _countColumns = 16;
            }
            animalListBox.IsEnabled = true;
        }

        private void Reset()
        {
            smallGameRadioButton.IsChecked = false;
            gameRadioButton.IsChecked = false;
            largeRadioButton.IsChecked = false;
            nameTextBox.Text = "";
            animalListBox.SelectedIndex = -1;
        }
    }
}
