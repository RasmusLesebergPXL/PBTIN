﻿using System.Windows;

namespace ShowABook_PropChanged
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
            this.DataContext = _currentBook;
        }
        
        private void updateButton_Click(object sender, RoutedEventArgs e)
        {
            //currentBook.Title = "Programmeren in C#, vernieuwde vierde editie";
            //TESTVRAAG:
            titleTextBlock.Text = "Programmeren in Python";
        }
    }
}