using InfluencerApp.UI.Command;

namespace InfluencerApp.UI.ViewModel;

public class MainViewModel : ViewModelBase
{
    public SearchViewModel SearchViewModel { get; }
    public HomeViewModel HomeViewModel { get; }

    private ViewModelBase _selectedViewModel;

    public ViewModelBase SelectedViewModel
    {
        get => _selectedViewModel;
        private set
        {
            _selectedViewModel = value;
            OnPropertyChanged();
        }
    }

    public DelegateCommand SelectViewModelCommand { get; }

    public MainViewModel(HomeViewModel homeViewModel, SearchViewModel searchViewModel)
    {
        HomeViewModel = homeViewModel;
        SearchViewModel = searchViewModel;

        SelectViewModelCommand = new DelegateCommand(SelectViewModel);

        SelectedViewModel = HomeViewModel;
    }

    private void SelectViewModel(object? obj)
    {
        ViewModelBase viewModel = (ViewModelBase)obj!;
        SelectedViewModel = viewModel;
    }
}