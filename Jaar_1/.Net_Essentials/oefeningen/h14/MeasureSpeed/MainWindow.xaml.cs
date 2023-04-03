﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
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

namespace MeasureSpeed
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Stopwatch _stopwatch = new Stopwatch();

        private IDictionary<int, Course> _vakken = new Dictionary<int, Course>();
        private Course[] _vakkenarray = new Course[5];
        private List<Course> _courses = new List<Course>();

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

            _courses.Add(new Course(".NET Essentials", "Kris Hermans", 6));
            _courses.Add(new Course("Data Advanced", "Simeon Anwalt", 3));
            _courses.Add(new Course("Java", "Nele Custers", 6));
            _courses.Add(new Course("Networks Essentials", "Networ Meneer", 3));
            _courses.Add(new Course("Communication Skills", "Caroline Simons", 6));
        }

        private void zoekButton_Click(object sender, RoutedEventArgs e)
        {
            _stopwatch.Start();

            string vak = vakInput.Text;
            foreach (KeyValuePair<int, Course> entry in _vakken)
            {
                if (vak == entry.Value.Vak)
                {
                    vakOutput.Text = entry.Value.ToString();

                    _stopwatch.Stop();
                    TimeSpan elapsed = _stopwatch.Elapsed;
                    MessageBox.Show($"Duur: {elapsed.Seconds} sec en {elapsed.Milliseconds} msec");
                }
                else if (!_vakken.Contains(entry))
                {
                    MessageBox.Show(entry.Value.Vak + " does not exist in the Dictionary");
                }
            }
        }

        private void arrayButton_Click(object sender, RoutedEventArgs e)
        {
            _stopwatch.Start();
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

                _stopwatch.Stop();
                TimeSpan elapsed = _stopwatch.Elapsed;
                MessageBox.Show($"Duur: {elapsed.Seconds} sec en {elapsed.Milliseconds} msec");
            }
            else
            {
                MessageBox.Show(vak + " does not exist");
            }
        }

        private void listButton_Click(object sender, RoutedEventArgs e)
        {
            string vak = vakInput.Text;
            string resultaat = "";
            foreach (Course course in _courses)
            {
                if (vak == course.Vak)
                {
                    resultaat = course.ToString();
                }
            }
            if (resultaat != "")
            {
                vakOutput.Text = resultaat;

                _stopwatch.Stop();
                TimeSpan elapsed = _stopwatch.Elapsed;
                MessageBox.Show($"Duur: {elapsed.Seconds} sec en {elapsed.Milliseconds} msec");
            }
            else
            {
                MessageBox.Show(vak + " does not exist");
            }
        }
    }
}
