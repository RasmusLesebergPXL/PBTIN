using System;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace LoadAnImage
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
        }

        private async void loadButton_Click(object sender, RoutedEventArgs e)
        {
            Uri assetUri = new Uri("ms-appx:///Assets/cookies.jpg");
            StorageFile file = await StorageFile.GetFileFromApplicationUriAsync(assetUri);
            BitmapImage bitmapImage = new BitmapImage();
            IRandomAccessStream fileStream = await file.OpenAsync(FileAccessMode.Read);
            bitmapImage.SetSource(fileStream);
            theImage.Source = bitmapImage;
        }
    }
}
