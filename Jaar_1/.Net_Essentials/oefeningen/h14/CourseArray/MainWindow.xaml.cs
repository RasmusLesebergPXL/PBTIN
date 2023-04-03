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

namespace CourseArray
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        IDictionary<int, Course> _vakken = new Dictionary<int, Course>();
        Course[] _vakkenarray = new Course[5];

        public MainWindow()
        {
            InitializeComponent();
            _vakken.Add(1, new Course(".NET Essentials", "Kris Hermans", 6));
            _vakken.Add(2, new Course("Data Advanced", "Simeon Anwalt", 3));
            _vakken.Add(3, new Course("Java", "Nele Custers", 6));
            _vakken.Add(4, new Course("Networks Essentials", "Networ Meneer", 3));
            _vakken.Add(5, new Course("Communication Skills", "Caroline Simons", 6));

            _vakkenarray[0] = new Course(".NET Essentials", "Kris Hermans", 6);
            _vakkenarray[1] = new Course("Data Advanced", "Simeon Anwalt", 3);
            _vakkenarray[2] = new Course("Java", "Nele Custers", 6);
            _vakkenarray[3] = new Course("Networks Essentials", "Networ Meneer", 3);
            _vakkenarray[4] = new Course("Communication Skills", "Caroline Simons", 6);
        }

        private void zoekButton_Click(object sender, RoutedEventArgs e)
        {
            string vak = vakInput.Text;

            foreach (KeyValuePair<int, Course> entry in _vakken)
            {
                if (vak == entry.Value.Vak)
                {
                    vakOutput.Text = entry.Value.ToString();
                }
                else if (!_vakken.Contains(entry))
                {
                    MessageBox.Show(entry.Value.Vak + " does not exist in the Dictionary");
                }
            }
        }

        private void arrayButton_Click(object sender, RoutedEventArgs e)
        {
            string vak = vakInput.Text;
            string resultaat = "";
            foreach (Course course in _vakkenarray)
            {
                if (vak == course.Vak)
                {
                    resultaat = course.ToString();
                }
            }
            if (resultaat != "")
            {
                vakOutput.Text = resultaat;
            } else
            {
                MessageBox.Show(vak + " does not exist");
            }
        }
    }
}
