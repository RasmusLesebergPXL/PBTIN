using Exercise2.Data;
using Exercise2.Model;
using System.Collections.Generic;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace Exercise2.ViewModel;

public class SideBarViewModel : ViewModelBase, ISideBarViewModel, INotifyPropertyChanged
{
    private IMovieRepository _movieRepository = new MovieRepository();
    private IList<Movie> _movies = new List<Movie>();
    private Movie _movie = new();
    public SideBarViewModel(IMovieRepository movieRepository)
    {
        _movieRepository = movieRepository;
    }

    public event PropertyChangedEventHandler? PropertyChanged;

    public IList<Movie> Movies
    {
        get { return _movies; }
        private set
        {
            if (_movies != value)
            {
                _movies = value;
                OnPropertyChanged();
            }
        }

    }

    public Movie? SelectedMovie
    {
        get { return _movie; }
        set
        {
            if (_movie != value && value != null)
            {
                _movie = value;
                OnPropertyChanged();
            }
        }
    } 

    public override void Load()
    {
        Movies = _movieRepository.GetAll();
    }

    protected void OnPropertyChanged([CallerMemberName] string? name = null)
    {
        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
    }
}