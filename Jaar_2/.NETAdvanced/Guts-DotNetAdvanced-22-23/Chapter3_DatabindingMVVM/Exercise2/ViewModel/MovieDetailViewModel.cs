using Exercise2.Command;
using Exercise2.Model;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace Exercise2.ViewModel;

public class MovieDetailViewModel : ViewModelBase, IMovieDetailViewModel, INotifyPropertyChanged
{
    private Movie? _movie = new();
    public MovieDetailViewModel()
    {
        GiveFiveStarRatingCommand = new DelegateCommand(FiveStars, FiveStarPossible);
    }

    public event PropertyChangedEventHandler? PropertyChanged;
    public DelegateCommand GiveFiveStarRatingCommand { get; set; }

    public Movie? Movie
    {
        get { return _movie; }
        set
        {
            if (_movie != value)
            {
                _movie = value;
                HasNoMovie = false;
                GiveFiveStarRatingCommand.RaiseCanExecuteChanged();
                OnPropertyChanged();
                if (_movie != null)
                {
                    _movie.PropertyChanged += Movie_PropertyChanged;
                }
            }
        }
    }

    private void Movie_PropertyChanged(object? sender, PropertyChangedEventArgs e)
    {
        GiveFiveStarRatingCommand.RaiseCanExecuteChanged();
    }

    public bool HasNoMovie
    { 
        get { return _movie == null; }
        set { OnPropertyChanged(); }
    }

    private bool FiveStarPossible(object? parameter) => !HasNoMovie && Movie?.Rating != 5;
    public void FiveStars(object? parameter) => Movie!.Rating = 5;


    public override void Load()
    {
        
    }

    protected void OnPropertyChanged([CallerMemberName] string? name = null)
    {
        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
    }
}