using HighSalesEF.Models;
using Microsoft.EntityFrameworkCore;

namespace HighSalesEF.Repositories
{
    public class MusicSalesContext : DbContext
    {
        private const string ConnectionString =
            @"Data source=(localdb)\mssqllocaldb;" +
            @"Initial Catalog=MusicSales;Integrated Security=True";

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(ConnectionString);
        }

        public DbSet<Artist> Artists { get; set; }
    }
}