using ArtistBrowserSQL.Models;
using System.Collections.Generic;

namespace ArtistBrowserSQL.Repositories
{
    interface IArtistRepository
    {
        IList<Artist> GetAll();
        void Update(Artist artist);
    }
}
