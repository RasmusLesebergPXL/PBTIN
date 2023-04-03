using System.Collections.Generic;
using HighSalesEF.Models;
using System.Linq;

namespace HighSalesEF.Repositories
{
    public class ArtistRepository : IArtistRepository
    {
        private MusicSalesContext _context = new MusicSalesContext();

        public IList<Artist> GetAllSalesAbove(double minimumSale)
        {
            return _context.Artists.Where(a => a.Sales >= minimumSale).ToList();
        }
    }
}
