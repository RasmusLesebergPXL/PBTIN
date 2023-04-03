using System.ComponentModel;

namespace Exercise2.ViewModel;

public class MainViewModel : ViewModelBase, IMainViewModel
{
    public MainViewModel(ISideBarViewModel sideBarViewModel,
        IMovieDetailViewModel movieDetailViewModel)
    {
        SideBarViewModel = sideBarViewModel;
        MovieDetailViewModel = movieDetailViewModel;
        SideBarViewModel.PropertyChanged += SideBarViewModel_PropertyChanged;
    }

    private void SideBarViewModel_PropertyChanged(object? sender, PropertyChangedEventArgs e)
    {
        MovieDetailViewModel.Movie = SideBarViewModel.SelectedMovie;
    }

    public ISideBarViewModel SideBarViewModel { get; set; }

    public IMovieDetailViewModel MovieDetailViewModel { get; set; }

    public event PropertyChangedEventHandler? PropertyChanged;

    public override void Load()
    {
        SideBarViewModel.Load();
    }

}