namespace InfluencerApp.AppLogic;

public interface IInfluencerService
{
    IReadOnlyList<InfluencerSummary> Find(string searchTerm, int minimumNumberOfVideos);
}