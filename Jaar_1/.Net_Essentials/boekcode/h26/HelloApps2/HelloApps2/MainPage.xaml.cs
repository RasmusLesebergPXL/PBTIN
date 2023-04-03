using HelloApps2.Quotes;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace HelloApps2
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private IQuote _quote;

        public MainPage()
        {
            this.InitializeComponent();
        }

        private void sayButton_Click(object sender, RoutedEventArgs e)
        {
            _quote = QuoteFactory.Create();
            statusTextBlock.Text = _quote.SayHello();
        }
    }
}
