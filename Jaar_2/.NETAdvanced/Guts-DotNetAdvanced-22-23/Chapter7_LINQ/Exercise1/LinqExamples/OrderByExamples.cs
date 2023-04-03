using LinqExamples.Models;

namespace LinqExamples;

public class OrderByExamples
{
    public double[] SortAnglesFromBigToSmall(double[] angles)
    {
        var angleQuery =
            (from angle in angles
             orderby angle descending
             select angle).ToArray();

        return angleQuery;
    }

    public IList<Person> SortPersonsFromYoungToOldAndThenOnNameAlphabetically(List<Person> persons)
    {
        var nameQuery =
            (from person in persons
             orderby person.BirthDate ascending
             orderby person.Name
             select person).ToList();

        return nameQuery;
    }
}