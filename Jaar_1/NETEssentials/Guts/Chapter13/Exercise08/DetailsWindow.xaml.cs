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
using System.Windows.Shapes;

namespace Exercise08
{
    /// <summary>
    /// Interaction logic for DetailsWindow.xaml
    /// </summary>
    public partial class DetailsWindow : Window
    {
        private Person _person;
        public DetailsWindow(Person person)
        {
            InitializeComponent();

            _person = person;
            lastNameTextBox.Text = _person.Name;
            firstNameTextBox.Text = _person.FirstName;
            addressTextBox.Text = _person.Adress;
            maleRadioButton.IsChecked = (_person.Gender == GenderType.Male);
            femaleRadioButton.IsChecked = (_person.Gender == GenderType.Female);
            phoneTextBox.Text = _person.TelephoneNumber;
            birthDateDatePicker.Text = Convert.ToString(_person.BirthDate);
        }

        private void cancelButton_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void okButton_Click(object sender, RoutedEventArgs e)
        {
            _person.Name = lastNameTextBox.Text;
            _person.FirstName = firstNameTextBox.Text;
            _person.Gender = (maleRadioButton.IsChecked == true ? _person.Gender = GenderType.Male : _person.Gender = GenderType.Female);
            _person.Adress = addressTextBox.Text;
            _person.TelephoneNumber = phoneTextBox.Text;
            _person.BirthDate = (DateTime)birthDateDatePicker.SelectedDate;
            this.Close();
        }
    }
}
