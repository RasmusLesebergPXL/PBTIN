namespace Exercise1;

public static class CompositionFilters
{
    public static CompositionFilterDelegate QuickFilter
    {
        get
        {
            return (composition, keyword) => composition.Title.Contains(keyword);
        }
    }

    public static CompositionFilterDelegate DetailedFilter
    {
        get
        {
            return (composition, keyword) => composition.Description.Contains(keyword) || composition.Title.Contains(keyword);
        }
    }

    public static CompositionFilterDelegate ReleaseYearFilter
    {
        get
        {
            return (composition, year) => composition.ReleaseDate.Year.ToString() == year;
        }
    }

}