using Microsoft.Win32;
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

namespace MenuTest
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private OpenFileDialog _openFileDialog = new OpenFileDialog();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void exitMenutem_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }

        private void open_Click(object sender, RoutedEventArgs e)
        {
            string startFolder = Environment.GetFolderPath(
                                 Environment.SpecialFolder.MyPictures);
            _openFileDialog.InitialDirectory = startFolder;
            _openFileDialog.Filter = "Image Files|*.BMP;" +
                                    "*.JPG;*.GIF|All files (*.*)|*.*";

            if (_openFileDialog.ShowDialog() == true) // User clicks Open
            {
                MessageBox.Show(_openFileDialog.FileName);
            }
        }

        private void save_Click(object sender, RoutedEventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.InitialDirectory = Environment.GetFolderPath(
                                         Environment.SpecialFolder.MyDocuments);
            if (dialog.ShowDialog() == true) // User clicks Save
            {
                MessageBox.Show(dialog.FileName);
            }
        }
    }
}
