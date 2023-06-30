using System.Windows;
using InfluencerApp.UI.ViewModel;

namespace InfluencerApp.UI
{
    public partial class MainWindow : Window
    {
        private readonly MainViewModel _viewModel;

        public MainWindow(MainViewModel mainViewModel)
        {
            InitializeComponent();

            _viewModel = mainViewModel;
            DataContext = _viewModel;
        }
    }
}
