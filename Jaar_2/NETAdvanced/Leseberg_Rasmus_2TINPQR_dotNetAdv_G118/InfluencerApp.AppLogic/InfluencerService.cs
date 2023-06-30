using InfluencerApp.Domain;

namespace InfluencerApp.AppLogic
{
    internal class InfluencerService : IInfluencerService
    {
        private IInfluencerRepository _influencerRepository;

        public InfluencerService(IInfluencerRepository repository)
        {
            _influencerRepository = repository;
        }
        public IReadOnlyList<InfluencerSummary> Find(string searchTerm, int minimumNumberOfVideos)
        {
            IReadOnlyList<Influencer>? influencers = _influencerRepository.Find(searchTerm, minimumNumberOfVideos);


            var influencerRepositoryQuery =
            (from influencer in influencers
             select new InfluencerSummary
             {
                 Id = influencer.Id,
                 Name = influencer.Name!,
                 Description = influencer.Description,
                 NumberOfVideos = influencer.Videos!.Count,
             }).ToList();

            return influencerRepositoryQuery;


        }
    }
}
