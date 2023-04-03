using ArtistBrowserEF.Models;
using System.Collections.Generic;

namespace ArtistBrowserEF.Repositories
{
    interface IArtistRepository
    {
        IList<Artist> GetAll();
        void Update(Artist artist);
    }
}
