using InfluencerApp.Domain;

namespace InfluencerApp.AppLogic
{
    public interface IInfluencerRepository
    {
        IReadOnlyList<Influencer> Find(string searchTerm, int minimumNumberOfVideos);

        Influencer Add(string name, string? description, string[] videoUrls);
    }
}