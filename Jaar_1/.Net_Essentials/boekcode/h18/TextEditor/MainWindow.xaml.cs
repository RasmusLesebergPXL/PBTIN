using Microsoft.Win32;
using System;
using System.IO;
using System.Windows;

namespace TextEditor
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string _currentFilePath = "";
        private string _initialFolderPath;

        public MainWindow()
        {
            InitializeComponent();

            _initialFolderPath = Environment.GetFolderPath(
                            Environment.SpecialFolder.MyDocuments);
        }

        private void openMenuItem_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog();
            dialog.InitialDirectory = _initialFolderPath;
            if (dialog.ShowDialog() == true)
            {
                _currentFilePath = dialog.FileName;
                using StreamReader reader = File.OpenText(_currentFilePath);
                mainTextBox.Text = reader.ReadToEnd();
            }
        }

        private void saveMenuItem_Click(object sender, RoutedEventArgs e)
        {
            if (_currentFilePath == "")
            {
                SaveFileDialog dialog = new SaveFileDialog();
                dialog.InitialDirectory = _initialFolderPath;
                if (dialog.ShowDialog() == true)
                {
                    _currentFilePath = dialog.FileName;
                }
            }
            using StreamWriter writer = File.CreateText(_currentFilePath);
            writer.Write(mainTextBox.Text);
        }

        private void saveAsMenuItem_Click(object sender, RoutedEventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.InitialDirectory = _initialFolderPath;
            if (dialog.ShowDialog() == true)
            {
                _currentFilePath = dialog.FileName;
                using StreamWriter writer = File.CreateText(_currentFilePath);
                writer.Write(mainTextBox.Text);
            }
        }

        private void exitMenuItem_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
