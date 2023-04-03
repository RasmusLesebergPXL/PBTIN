using System.Collections.Generic;
using ArtistBrowserEF.Models;
using System.Linq;

namespace ArtistBrowserEF.Repositories
{
    public class EFArtistRepository : IArtistRepository
    {
        private MusicSalesContext _context = new MusicSalesContext();

        public IList<Artist> GetAll()
        {
            return _context.Artists.ToList<Artist>();
        }

        public void Update(Artist artist)
        {
            _context.SaveChanges();
        }
    }
}
