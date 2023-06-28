using System;

namespace BikeRent
{
    public static class BusinessRules // this should remain static!
    {
        public static double CalculatePrice(int days, double pricePerDay)
        {
            if (days == 1)
            {
                return pricePerDay;
            } else if (days == 2)
            {
                return pricePerDay - (pricePerDay * 0.2);
            }
            return pricePerDay - (pricePerDay * 0.3);
        }


        // ToDo: implement CheckStartDate(string text)
        //       should be of format dd/mm/jjjj
        //       should not be in the past
        //       throws a ValidationException if these rules are violated

        public static DateTime CheckStartDate(string text)
        {         
            DateTime date;
            if (text != null)
            {
                if (DateTime.TryParse(text, out _))
                {
                    date = Convert.ToDateTime(text);
                    if (Convert.ToDateTime(text) < DateTime.Now)
                    {
                        throw new ValidationException($"({text}) mag niet in het verleden liggen");
                    }
                    else
                    {
                        return date;
                    }                    
                }
                else
                {
                    throw new ValidationException($"({text}) is geen geldige datum van het formaat dd/mm/jjjj");
                }
            }
            throw new ValidationException("Date is undefined");
        }
    }
}