using System.Windows;
using InfluencerApp.AppLogic;
using InfluencerApp.Infrastructure;
using InfluencerApp.UI.ViewModel;

namespace InfluencerApp.UI
{
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            InfluencerContext context = new InfluencerContext();
            IInfluencerRepository influencerRepository = new InfluencerDbRepository(context);

            //TODO: assign an instance of RandomDataSeeder
            IDataSeeder seeder = new RandomDataSeeder(influencerRepository, context); 
            seeder?.SeedKnownInfluencers();

            //TODO: create MainViewModel to inject into MainWindow

            var service = new InfluencerService(influencerRepository);

            HomeViewModel homeViewModel = new();
            SearchViewModel searchViewModel = new(service)
                ;
            MainViewModel mainViewModel = new(homeViewModel, searchViewModel);

            var mainWindow = new MainWindow(mainViewModel);
            mainWindow.Show();
        }
    }
}
