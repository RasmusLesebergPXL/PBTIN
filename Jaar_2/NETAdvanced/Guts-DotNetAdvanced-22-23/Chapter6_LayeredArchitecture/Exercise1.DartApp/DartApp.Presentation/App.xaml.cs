using DartApp.AppLogic;
using DartApp.AppLogic.Contracts;
using DartApp.Infrastructure.Storage;

using System;
using System.IO;
using System.Windows;

namespace DartApp.Presentation
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            string path = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData), "DartApp");
            PlayerFileRepository repository = new PlayerFileRepository(path);
            PlayerService service = new PlayerService(repository);
            MainWindow window = new MainWindow(service);
            window.Show();
        }
    }
}
