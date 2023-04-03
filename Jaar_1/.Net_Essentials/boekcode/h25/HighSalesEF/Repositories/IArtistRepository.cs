using HighSalesEF.Models;
using System.Collections.Generic;

namespace HighSalesEF.Repositories
{
    interface IArtistRepository
    {
        IList<Artist> GetAllSalesAbove(double minimumSale);
    }
}
