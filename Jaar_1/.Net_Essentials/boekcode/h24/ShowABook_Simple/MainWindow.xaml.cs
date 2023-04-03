using System.Windows;

namespace ShowABook_Simple
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Book _currentBook;
        
        public MainWindow()
        {
            InitializeComponent();
            _currentBook = FindBook();
        }

        private Book FindBook()
        {
            return new Book()
            {
                ISBN = 9879043023421,
                Title = @"Programmeren in C#, tweede editie"
            };
        }

        private void showButton_Click(object sender, RoutedEventArgs e)
        {
            isbnTextBlock.Text = $"{_currentBook.ISBN}";
            titleTextBlock.Text = _currentBook.Title;
        }
    }
}
