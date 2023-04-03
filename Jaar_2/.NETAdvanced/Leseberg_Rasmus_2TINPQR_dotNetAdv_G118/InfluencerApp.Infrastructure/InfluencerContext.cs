using InfluencerApp.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using System.Diagnostics;

namespace InfluencerApp.Infrastructure;

internal class InfluencerContext : DbContext
{
    public DbSet<Influencer> Influencers => Set<Influencer>();

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        if (!optionsBuilder.IsConfigured)
        {
            optionsBuilder
            .UseSqlServer("Data Source=(localdb)\\MSSQLLocalDB; Initial Catalog = InfluencerDb; Integrated Security = True;")
            .LogTo(message => Debug.WriteLine(message), new[]
            {
                DbLoggerCategory.Database.Command.Name
            }, LogLevel.Information);
        }
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Influencer>()
            .Property(s => s.Name)
            .HasMaxLength(100);
    }
}