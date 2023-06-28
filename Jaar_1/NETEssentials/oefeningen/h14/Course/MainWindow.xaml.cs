using System.Collections.Generic;
using System.Windows;

namespace Course
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        IDictionary<int, Course> _vakken = new Dictionary<int, Course>();
        public MainWindow()
        {
            InitializeComponent();
            _vakken.Add(1, new Course(".NET Essentials", "Kris Hermans", 6));
            _vakken.Add(2, new Course("Data Advanced", "Simeon Anwalt", 3));
            _vakken.Add(3, new Course("Java", "Nele Custers", 6));
            _vakken.Add(4, new Course("Networks Essentials", "Networ Meneer", 3));
            _vakken.Add(5, new Course("Communication Skills", "Caroline Simons", 6));
        }

        private void zoekButton_Click(object sender, RoutedEventArgs e)
        {
            string vak = vakInput.Text;

            foreach (KeyValuePair<int, Course> entry in _vakken)
            {
                if (vak == entry.Value.Vak)
                {
                    vakOutput.Text = entry.Value.ToString();
                } else if (!_vakken.Contains(entry))
                {
                    MessageBox.Show(entry.Value.Vak + " does not exist in the Dictionary");
                }
            }
        }
    }
}
