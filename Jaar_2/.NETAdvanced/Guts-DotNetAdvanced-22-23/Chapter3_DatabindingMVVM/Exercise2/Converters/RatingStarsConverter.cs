using System.Globalization;
using System.Windows.Data;
using System;

namespace Exercise2.Converters
{
    public class RatingStarsConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int amount = (int)value;
            switch (amount)
            {
                case 2:
                    return "**";
                case 3:
                    return "***";
                case 4:
                    return "****";
                case 5:
                    return "*****";
                default:
                    break;
            }
            return "*";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            return null;
        }
    }
}
