using InfluencerApp.AppLogic;
using InfluencerApp.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfluencerApp.Infrastructure
{
    internal class InfluencerDbRepository : IInfluencerRepository
    {
        private readonly InfluencerContext _context;

        public InfluencerDbRepository(InfluencerContext context)
        {
            _context = context;
        }
        public Influencer Add(string name, string? description, string[] videoUrls)
        {
            IList<Video> videos = new List<Video>();

            foreach (string url in videoUrls)
            {
                Video video = new()
                {
                    Url = url
                };
                videos.Add(video);
            }
            Influencer newInfluencer = new()
            {
                Name = name,
                Description = description,
                Videos = videos
            };

            _context.Influencers.Add(newInfluencer);
            _context.SaveChanges();
            return newInfluencer;
        }

        public IReadOnlyList<Influencer> Find(string searchTerm, int minimumNumberOfVideos)
        {
            var influencerQuery =
                (from influencer in _context.Influencers
                 where influencer.Description!.ToLower().Contains(searchTerm.ToLower()) || influencer.Name!.ToLower().Contains(searchTerm.ToLower())
                 where influencer.Videos!.Count >= minimumNumberOfVideos
                 select influencer).ToList();

            return influencerQuery;
        }
    }
}
