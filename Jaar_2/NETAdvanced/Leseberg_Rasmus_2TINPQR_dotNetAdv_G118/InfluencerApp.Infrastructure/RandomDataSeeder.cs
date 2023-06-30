using InfluencerApp.AppLogic;
using InfluencerApp.Domain;

namespace InfluencerApp.Infrastructure;

// DO NOT CHANGE CODE IN THIS FILE!!!

internal class RandomDataSeeder : IDataSeeder
{
    private readonly IInfluencerRepository _influencerRepository;
    private readonly InfluencerContext _context;
    private readonly Random _random;

    public RandomDataSeeder(IInfluencerRepository influencerRepository, InfluencerContext context)
    {
        // DO NOT CHANGE CODE IN THIS FILE!!!
        _influencerRepository = influencerRepository;
        _context = context;
        _random = new Random();
    }

    /// <summary>
    /// Adds some random influencers to the database if the database does not contain any influencer.
    /// An IInfluencerRepository is used to add the influencers.
    /// </summary>
    public void SeedKnownInfluencers()
    {
        if (_context.Set<Influencer>().Any()) return;

        int numberOfInfluencers = _random.Next(6, 13);

        string[] firstNames = { "John", "Jane", "Jeff", "Ann", "Jimmy", "Tiffany" };
        string[] lastNames = { "Skywalker", "Buckley", "Doe", "Smith", "Simpson", "Bale" };
        string[] categories = { "muziek", "sport", "mode", "wetenschap", "film", "TV", "politiek" };
        for (int i = 0; i < numberOfInfluencers; i++)
        {
            string firstName = firstNames[_random.Next(firstNames.Length)];
            string lastName = lastNames[_random.Next(lastNames.Length)];
            string name = $"{firstName} {lastName}";
            string description = $"Beroemde influencer in de categorie {categories[_random.Next(categories.Length)]}";
            int numberOfVideos = _random.Next(2, 9);
            string[] videoUrls = new string[numberOfVideos];
            for (int j = 0; j < numberOfVideos; j++)
            {
                videoUrls[j] = $"https://{firstName.ToLower()}{lastName.ToLower()}.com/{Guid.NewGuid()}";
            }

            _influencerRepository.Add(name, description, videoUrls);
        }
    }
}