using System;
using System.Windows;
using System.Windows.Controls;

namespace PixelPass
{
    /// <summary>
    /// Interaction logic for CreateOrUpdateAccountInfoWindow.xaml
    /// </summary>
    public partial class CreateAccountInfoWindow : Window
    {
        private IAccountInfoCollection _collection;
        private AccountInfo _account;
        private DateTime _sliderTime;
        private Slider _slider;
        public CreateAccountInfoWindow(IAccountInfoCollection collection)
        {
            InitializeComponent();

            _collection = collection;
            _slider = expirationSlider;
            _slider.ValueChanged += ExpirationSlider_ValueChanged;
            _sliderTime = new DateTime();
            _account = new AccountInfo();

            passwordStrengthTextBlock.Text = "(Weak)";
            expirationDateTextBlock.Text = $"{DateTime.Now + TimeSpan.FromDays(_slider.Value):dd/MM/yyyy}";
        }

        private void ExpirationSlider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            _sliderTime = DateTime.Now.AddDays(_slider.Value);
            expirationDateTextBlock.Text = Convert.ToString(_sliderTime.ToString("dd/MM/yyyy"));               
        }

        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            _account.Title = titleTextBox.Text;
            _account.Username = usernameTextBox.Text;
            _account.Password = passwordTextBox.Text;
            _account.Notes = notesTextBox.Text;
            _account.Expiration = Convert.ToDateTime(expirationDateTextBlock.Text);

            _collection.AccountInfos.Add(_account);

            Close();
        }

        private void PasswordTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            Strength strength = PasswordValidator.CalculateStrength(passwordTextBox.Text);
            passwordStrengthTextBlock.Text = Convert.ToString($"({strength})");
        }
    }
}
