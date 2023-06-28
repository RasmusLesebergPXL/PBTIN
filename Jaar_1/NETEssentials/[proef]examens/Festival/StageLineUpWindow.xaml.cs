using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.IO;
using System.Windows;

namespace Festival
{
    /// <summary>
    /// Interaction logic for StageLineUpWindow.xaml
    /// </summary>
    public partial class StageLineUpWindow : Window
    {
        private List<Performer> _performers;
        private string _filePath;
        public StageLineUpWindow()
        {
            InitializeComponent();
            _performers = new List<Performer>();
        }

        //TODO: zorg dat onderstaande code werkt, volgens richtlijnen opgave
        public void DisableEvents()
        {
            removeButton.IsEnabled = false;
            addButton.IsEnabled = false;
        }

        //TODO: zorg dat onderstaande code werkt, volgens richtlijnen opgave
        public void EnableEvents()
        {
            removeButton.IsEnabled = true;
            addButton.IsEnabled = true;
        }

        private void RemoveButton_Click(object sender, RoutedEventArgs e)
        {
            //TODO:hier het juist item verwijderen uit de lijst.
            _performers.Remove((Performer) performListBox.SelectedItem);

            //tip om de getoonde lijst te updaten.
            performListBox.Items.Refresh();
        }

        private void AddButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                Window window = new NewActWindow(_performers);
                window.Show();
            }
            catch (FestivalException error)
            {
                MessageBox.Show(error.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
            finally
            {
                performListBox.Items.Refresh();
            }


        }

        private void OpenItem_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            string startFolder = Environment.GetFolderPath(
                                 Environment.SpecialFolder.Desktop);
            openFileDialog.InitialDirectory = startFolder;
            openFileDialog.Filter = "Text Files (*.txt)|*.txt;";

            if (openFileDialog.ShowDialog() == true) // User clicks Open
            {
                string filePath = System.IO.Path.Combine(
                                         startFolder, openFileDialog.FileName);
                _filePath = filePath;
                saveItem.IsEnabled = true;
                ReadItem(filePath);
            }
        }

        private void ReadItem(string filePath)
        {
            StreamReader reader = null;

            try
            {
                reader = File.OpenText(filePath);
                string line = reader.ReadLine();
            
                while (line != null)
                {
                    //Split line, make array for rider and supplies
                    string[] list = line.Trim().Split(',');
                    IList<string> items = new List<string>();
                    int[] supplies = { Convert.ToInt32(list[6]), Convert.ToInt32(list[7]) };

                    for (int i = 6; i < list.Length; i++)
                    {
                        items.Add(list[i]);
                    }
                    //Check if Band
                    if (list[0] == "B")
                    {         
                        Band newBand = new Band(list[2], Convert.ToInt32(list[3]), list[4], list[5], supplies, 
                                                items, Convert.ToInt32(list[1]));
                        _performers.Add(newBand);

                    }  
                    //Check if Solo Artist
                    else if (list[0] == "S")
                    {
                        Solo person = new Solo(list[2], Convert.ToInt32(list[3]), list[4], list[5], supplies,
                                                items, list[1]);
                        _performers.Add(person);
                    }
                    line = reader.ReadLine();
                }
                performListBox.ItemsSource = _performers;
            }
            finally
            {
                addButton.IsEnabled = true;
                removeButton.IsEnabled = true;
                reader?.Close();
            }
        }

        private void SaveItem_Click(object sender, RoutedEventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.InitialDirectory = Environment.GetFolderPath(
                                         Environment.SpecialFolder.Desktop);
            if (dialog.ShowDialog() == true) // User clicks Save
            {
                MessageBox.Show(dialog.FileName);
            }
        }

        private void ExitItem_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
