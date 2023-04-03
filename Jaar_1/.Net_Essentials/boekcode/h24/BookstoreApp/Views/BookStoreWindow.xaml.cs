using BookstoreApp.Models;
using System.Windows;
using System.Windows.Controls;

namespace BookstoreApp.Views
{
    public enum FormsMode
    {
        View,
        Edit
    }

    /// <summary>
    /// Interaction logic for BookStoreWindow.xaml
    /// </summary>
    public partial class BookStoreWindow : Window
    {
        private BookStore _bookStore;
        private Book _currentBookBackup;
        private FormsMode _currentMode;

        public BookStoreWindow()
        {
            InitializeComponent();

            _bookStore = new BookStore();
            booksListView.ItemsSource = _bookStore.GetAllBooks();

            booksListView.SelectedIndex = 0;
            this.DataContext = booksListView.SelectedItem;

            SwitchMode(FormsMode.View);
        }

        private void booksListView_SelectionChanged(object sender,
                                                    SelectionChangedEventArgs e)
        {
            this.DataContext = booksListView.SelectedItem;
        }

        private void SwitchMode(FormsMode mode)
        {
            _currentMode = mode;
            switch (mode)
            {
                case FormsMode.View:
                    cancelButton.Visibility = Visibility.Hidden;
                    editSaveButton.Content = "Bewerk";
                    titleTextBox.IsEnabled = false;
                    break;
                case FormsMode.Edit:
                    editSaveButton.Content = "Bewaar";
                    cancelButton.Visibility = Visibility.Visible;
                    titleTextBox.IsEnabled = true;
                    break;
                default:
                    break;
            }
        }

        private void editSaveButton_Click(object sender, RoutedEventArgs e)
        {
            if (_currentMode == FormsMode.View)
            {
                SwitchMode(FormsMode.Edit);
                Book selectedBook = (Book)booksListView.SelectedItem;
                _currentBookBackup = new Book()
                {
                    Title = selectedBook.Title,
                };
            }
            else
            {
                SwitchMode(FormsMode.View);
                _currentBookBackup = null;
            }
        }

        private void cancelButton_Click(object sender, RoutedEventArgs e)
        {
            //restore old values
            Book editedBook = (Book)booksListView.SelectedItem;
            editedBook.Title = _currentBookBackup.Title;
            SwitchMode(FormsMode.View);
            _currentBookBackup = null;
        }
    }
}
