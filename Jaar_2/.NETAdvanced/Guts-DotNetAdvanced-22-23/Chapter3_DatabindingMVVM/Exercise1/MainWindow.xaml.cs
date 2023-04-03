using Exercise2.Model;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Windows;

namespace Exercise1
{
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        private ObservableCollection<Movie> _movies = new();
        public MainWindow()
        {
            DataContext = this;
            InitializeComponent();
            IList<Movie> allMovies = GetDummyMovies();
            foreach(Movie movie in allMovies)
            {
                _movies.Add(movie);
            }
        }

        public event PropertyChangedEventHandler? PropertyChanged;

        private IList<Movie> GetDummyMovies()
        {
            var movies = new List<Movie>
            {
                new Movie
                {
                    Title = "The Godfather",
                    Director = "Francis Ford Coppola",
                    ReleaseYear = 1972
                },
                new Movie
                {
                    Title = "The Shawshank Redemption",
                    Director = "Frank Darabont",
                    ReleaseYear = 1994
                }
            };
            return movies;
        }

        public ObservableCollection<Movie> MovieCollection
        {
            get { return _movies; }
            set
            {
                if (_movies != value)
                {
                    _movies = value;
                    OnPropertyChanged();
                }
            }
        }

        protected void OnPropertyChanged([CallerMemberName] string? name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }

        private void AddNewMovieButton_Click(object sender, RoutedEventArgs e)
        {
            var newMovie = NewMovieGroupBox.DataContext as Movie;

            if (newMovie.Title == "Unknown")
            {
                ErrorMessageTextBlock.Text = "The title of the movie cannot be 'Unknown'";
            }
            else if (newMovie.Director == "Unknown")
            {
                ErrorMessageTextBlock.Text = "The director of the movie cannot be 'Unknown'";
            }
            else if (newMovie.ReleaseYear <= 0)
            {
                ErrorMessageTextBlock.Text = "The release year of the movie cannot be <= 0";
            }
            else
            {
                _movies.Add(newMovie);
                ErrorMessageTextBlock.Text = "";
                NewMovieGroupBox.DataContext = new Movie();
            }
        }
    }
}
