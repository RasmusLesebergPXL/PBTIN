using System;
using System.Globalization;
using System.Windows.Data;

namespace BookstoreApp.Converters
{
    public class CoverConverter : IValueConverter
    {
        public object Convert(object value, Type targetType,
                              object parameter, CultureInfo culture)
        {
            return $"/Covers/{value}.jpg";
        }

        public object ConvertBack(object value, Type targetType,
                                  object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
