using System;
using System.Collections.Generic;
using System.IO;
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

namespace write_test
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

        private void WriteButton_Click(object sender, RoutedEventArgs e)
        {
            StreamWriter writer = null;
            try
            {
                string folderPath = Environment.GetFolderPath(
                                      Environment.SpecialFolder.MyDocuments);
                string filePath = System.IO.Path.Combine(
                                            folderPath, "myfile.txt");
                writer = File.CreateText(filePath);
                writer.WriteLine("This file");
                writer.WriteLine("contains");
                writer.WriteLine("3 lines");
            } 
            finally
            {
                writer?.Close();
            }          
        }

        private void ReadButton_Click(object sender, RoutedEventArgs e)
        {
            StreamReader reader = null;
            try
            {
                string folderPath = Environment.GetFolderPath(
                                      Environment.SpecialFolder.MyDocuments);
                string filePath = System.IO.Path.Combine(
                                            folderPath, "myfile.txt");
                reader = File.OpenText(filePath);
                string line = reader.ReadLine();
                while (line != null)
                {
                    fileTextBox.AppendText(line);
                    fileTextBox.AppendText(Environment.NewLine);
                    line = reader.ReadLine();
                }
            }
            finally
            {
                reader?.Close();
            }
        }
    }
}
