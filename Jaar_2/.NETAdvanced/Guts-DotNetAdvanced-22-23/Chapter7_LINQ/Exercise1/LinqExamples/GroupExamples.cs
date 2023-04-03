using LinqExamples.Models;

namespace LinqExamples;

public class GroupExamples
{
    public IList<IGrouping<int, int>> GroupEvenAndOddNumbers(int[] numbers)
    {
        var evenQuery =
            (from number in numbers
             group number by number % 2).ToList();

        return evenQuery;
    }

    public IList<PersonsOfSameBirthYearGroup> GroupPersonsByBirthYear(IList<Person> persons)
    {
        var birthDayQuery =
            (from person in persons
             group person by person.BirthDate.Year into months
             select new PersonsOfSameBirthYearGroup
             {
                 BirthYear = months.Key,
                 Persons = months.ToList()

             }).ToList();

        return birthDayQuery;
    }
}