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
using System.Windows.Shapes;

namespace DominationGame
{
    /// <summary>
    /// Interaction logic for Moves.xaml
    /// </summary>
    public partial class Moves : Window
    {
        public Moves()
        {
            InitializeComponent();

            StreamReader reader = null;
            try
            {
                string folderPath = Environment.GetFolderPath(
                                      Environment.SpecialFolder.MyDocuments);
                string filePath = System.IO.Path.Combine(
                                            folderPath, "domination.txt");
                reader = File.OpenText(filePath);
                string line = reader.ReadLine();
                while (line != null)
                {
                    movesTextBox.AppendText(line);
                    movesTextBox.AppendText(Environment.NewLine);
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
