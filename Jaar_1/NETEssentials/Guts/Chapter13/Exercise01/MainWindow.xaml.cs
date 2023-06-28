using System.Windows;

namespace Exercise01
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void verwijderButton_Click(object sender, RoutedEventArgs e)
        {
            if (listboxRight.SelectedItem != null)
            {
                listboxRight.Items.Remove(listboxRight.SelectedItem);
            }
            //listboxRight.Items.RemoveAt(listboxRight.SelectedIndex);
        }

        private void listboxLeft_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            //listboxLeft.Items.Remove(listboxLeft.SelectedItem);
            if (listboxLeft.SelectedIndex != -1)
            {
                listboxLeft.Items.RemoveAt(listboxLeft.SelectedIndex);
            }
        }
    }
}
