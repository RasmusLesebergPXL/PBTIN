using Windows.UI.Xaml;

namespace HelloApps2.Quotes
{
    public class QuoteFactory
    {
        /// <summary>
        /// Creates a new Quote based on the current window width
        /// </summary>
        /// <returns>a new Quote object</returns>
        public static IQuote Create()
        {
            double width = Window.Current.Bounds.Width;
            IQuote quote = null;
            if (width >= 720)
            {
                quote = new WideQuote();
            }
            else
            {
                quote = new NarrowQuote();
            }
            return quote;
        }
    }
}
