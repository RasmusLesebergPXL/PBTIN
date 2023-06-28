using Microsoft.Win32;
using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;

namespace PixelPass
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private IAccountInfoCollection _accountInfoCollection;
        private AccountInfo _currentAccountInfo;
        private DispatcherTimer _timer;

        public MainWindow()
        {
            InitializeComponent();

            _timer = new DispatcherTimer();
            _timer.Tick += TimerTick;
            _timer.Interval = new TimeSpan(0, 0, 0, 1);
        }

        private void OpenItem_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            string startFolder = Environment.GetFolderPath(
                                 Environment.SpecialFolder.Desktop);
            openFileDialog.InitialDirectory = startFolder;

            if (openFileDialog.ShowDialog() == true)
            {
                string onlyFileName = openFileDialog.SafeFileName;
                try
                {
                    _accountInfoCollection = AccountInfoCollectionReader.Read(onlyFileName);
                    accountInfoListBox.ItemsSource = _accountInfoCollection.AccountInfos;
                    newAccountInfoButton.IsEnabled = true;

                }
                catch (ParseException error)
                {
                    MessageBox.Show(openFileDialog.FileName + " seems corrupt\n\n" +
                                    "Details: \n\n" + openFileDialog.FileName + error.Message, "Error",
                                    MessageBoxButton.OK, MessageBoxImage.Error);
                }
            }
        }

        private void AccountInfoListBox_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            if (accountInfoListBox.SelectedItem != null)
            {
                _currentAccountInfo = (AccountInfo) accountInfoListBox.SelectedItem;

                if (_currentAccountInfo.IsExpired)
                {
                    detailsCanvas.Background = new SolidColorBrush(Colors.LightCoral);
                    copyButton.IsEnabled = false;
                }
                else
                {
                    detailsCanvas.Background = new SolidColorBrush(Colors.White);
                    copyButton.IsEnabled = true;
                }
                titleTextBlock.Text = _currentAccountInfo.Title;
                usernameTextBlock.Text = _currentAccountInfo.Username;
                notesTextBlock.Text = _currentAccountInfo.Notes;
                expirationTextBlock.Text = _currentAccountInfo.Expiration.ToString("dd/MM/yyyy");
            }
        }

        private void NewAccountInfoButton_Click(object sender, RoutedEventArgs e)
        {
            CreateAccountInfoWindow window = new CreateAccountInfoWindow(_accountInfoCollection);
            window.ShowDialog();
            accountInfoListBox.Items.Refresh(); 
        }

        private void CopyButton_Click(object sender, RoutedEventArgs e)
        {
            copyButton.IsEnabled = false;
            expirationProgressBar.Value = 5;
            Clipboard.SetText(_currentAccountInfo.Password);
            _timer.Start();
        }

        private void TimerTick(object sender, EventArgs e)
        {
            expirationProgressBar.Value -= 1;

            if (expirationProgressBar.Value == 0)
            {
                _timer.Stop();
                copyButton.IsEnabled = true;
                Clipboard.Clear();
            }
        }
    }
}
