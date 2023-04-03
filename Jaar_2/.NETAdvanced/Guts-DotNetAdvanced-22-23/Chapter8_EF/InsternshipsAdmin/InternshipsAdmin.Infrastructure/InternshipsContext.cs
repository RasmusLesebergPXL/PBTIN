using InternshipsAdmin.Domain;
using Microsoft.EntityFrameworkCore;

namespace InternshipsAdmin.Infrastructure
{
    public class InternshipsContext : DbContext
    {

        public DbSet<Company> Companies => Set<Company>();
        public DbSet<Student> Students => Set<Student>();
        public DbSet<Contact> Contacts => Set<Contact>();
        public DbSet<Supervisor> Supervisors => Set<Supervisor>();


        public InternshipsContext() { }

        public InternshipsContext(DbContextOptions<InternshipsContext> options) : base(options) { }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=(localdb)\\mssqllocaldb; Initial Catalog=Internships");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var companies = new Company[]
            {
                new Company {CompanyId = 1, Name = "PXL Smart ICT", Address = "Elfde Liniestraat 26", Zip = "3500", City = "Hasselt"},
                new Company {CompanyId = 2, Name = "Datasense", Address = "Kempische Steenweg 309", Zip = "3500", City = "Hasselt"}
            };
            modelBuilder.Entity<Company>().HasData(companies);

            var students = new Student[]
            {
                new Student("Timmy")
                {
                    Id = 1,
                    SupervisorId = 1,
                    Department = Guid.NewGuid().ToString(),
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString()
                },
                new Student("Phillip")
                {
                    Id = 2,
                    SupervisorId = 1,
                    Department = Guid.NewGuid().ToString(),
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString()
                },
                new Student("Sofia")
                {
                    Id = 3,
                    SupervisorId = 2,
                    Department = Guid.NewGuid().ToString(),
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString()
                },
                new Student("Sarah")
                {
                    Id = 4,
                    SupervisorId = 2,
                    Department = Guid.NewGuid().ToString(),
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString()
                }
            };
            modelBuilder.Entity<Student>().HasData(students);

            var supervisors = new Supervisor[]
            {
                new Supervisor("Paul")
                {
                    Id = 1,
                    CompanyId = 1,
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString(),
                    JobTitle = Guid.NewGuid().ToString(),
                    Specialism = Guid.NewGuid().ToString()
                },
                new Supervisor("Tamara")
                {
                    Id = 2,
                    CompanyId = 2,
                    Email = Guid.NewGuid().ToString(),
                    Phone = Guid.NewGuid().ToString(),
                    JobTitle = Guid.NewGuid().ToString(),
                    Specialism = Guid.NewGuid().ToString()
                }
            };
            modelBuilder.Entity<Supervisor>().HasData(supervisors);
        }
    }
}
