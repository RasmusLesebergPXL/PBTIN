using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Exercise08
{
    public partial class MainWindow : Window
    {
        private List<Person> _people;
        public MainWindow()
        {
            InitializeComponent();

            _people = new List<Person>
            {
                new Person
                {
                    Name = "Hermans",
                    FirstName = "Kris",
                    Adress = "Kerkhof24, 3560 Houthalen",
                    BirthDate = new DateTime(1975, 5, 15),
                    TelephoneNumber = "1234567",
                    Gender = GenderType.Male
                },
                new Person
                {
                    Name = "Leseberg",
                    FirstName = "Rasmus",
                    Adress = "Muggenstraat 45, 3487 Hasselt",
                    BirthDate = new DateTime(1995, 7, 4),
                    TelephoneNumber = "3454656",
                    Gender = GenderType.Male
                },
                new Person
                {
                    Name = "Roos",
                    FirstName = "Liesl",
                    Adress = "Zwaluwstraat 12, 3500 Hasselt",
                    BirthDate = new DateTime(1999, 5, 20),
                    TelephoneNumber = "5646654",
                    Gender = GenderType.Female
                }, 
                new Person
                {
                    Name = "Nielsen",
                    FirstName = "Allis",
                    Adress = "Birkeroedvej 16, 120 Hilleroed",
                    BirthDate = new DateTime(1945, 9, 18),
                    TelephoneNumber = "564655644",
                    Gender = GenderType.Female
                },
                new Person
                {
                    Name = "Cruise",
                    FirstName = "Tom",
                    Adress = "Negra Aroya Lane 111, 2363 California",
                    BirthDate = new DateTime(1964, 10, 22),
                    TelephoneNumber = "56456565",
                    Gender = GenderType.Male
                }
            };

            peopleListBox.ItemsSource = _people;
        }

        private void peopleListBox_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            if (peopleListBox.SelectedItem != null)
            {
                Window window = new DetailsWindow(_people[peopleListBox.SelectedIndex]);
                window.Show();
                window.Closed += Window_Closed;
            }
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            peopleListBox.Items.Refresh();
        }
    }
}
