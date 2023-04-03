using LinqExamples.Models;

namespace LinqExamples;

public class WhereExamples
{
    public int[] FilterOutNumbersDivisibleByTen(int[] numbers)
    {
        var numberQuery =
            (from number in numbers
             where number % 2 == 0
             select number).ToArray();

        return numberQuery;
    }

    public IList<Person> FilterOutPersonsThatAreEighteenOrOlder(List<Person> persons)
    {
        var ageQuery =
            (from person in persons
             where DateTime.Now.Year - person.BirthDate.Year >= 18
             select person).ToList();

        return ageQuery;
    }
}