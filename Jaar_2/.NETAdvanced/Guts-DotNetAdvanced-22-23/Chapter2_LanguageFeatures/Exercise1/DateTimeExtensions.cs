namespace Exercise1
{
    public static class DateTimeExtensions
    {
        public static string ToCentury(this DateTime date)
        {
            return date.Year.ToString().Substring(2, 2) == "00" ?
                
            int.Parse(date.Year.ToString()[..2]).ToString()     :
            (int.Parse(date.Year.ToString()[..2]) + 1).ToString();
        }
       
    }
}
