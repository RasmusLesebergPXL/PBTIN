using InternshipsAdmin.AppLogic.Contracts;
using InternshipsAdmin.Domain;
using Microsoft.EntityFrameworkCore;
using System.Diagnostics.CodeAnalysis;

namespace InternshipsAdmin.Infrastructure
{
    internal class CompanyRepository : ICompanyRepository
    {
        private readonly InternshipsContext _context;

        public CompanyRepository(InternshipsContext context)
        {
            _context = context;
        }

        public void Add(Company company)
        {
            _context.Companies.Add(company);
            _context.SaveChanges();
        }

        public IList<Company> GetAll()
        {
            return _context.Companies.ToList();
        }

        public Contact GetContactOfCompany(int companyId)
        {
            var contactQuery =
                from company in _context.Companies
                where company.CompanyId == companyId
                select company.Contact;

            return new Contact(contactQuery.First().Name);
        }

        public List<Supervisor> GetSupervisorsOfCompany(int companyId)
        {
            var supervisorQuery =
                (from company in _context.Companies
                where company.CompanyId == companyId
                select company.Supervisors).ToList();

            return new List<Supervisor>(supervisorQuery.First());
        }

        public List<Student> GetStudentsOfCompany(int companyId)
        {
            StudentsRepository studentsRepository = new(_context);
            IList<Student> allStudents = new List<Student>(studentsRepository.GetAll());
            IList<Supervisor> allSupervisors = GetSupervisorsOfCompany(companyId);

            var studentQuery =
                (from student in allStudents
                join supervisor in allSupervisors on student.SupervisorId equals supervisor.Id
                where supervisor.CompanyId == companyId
                select student).ToList();

            return studentQuery;
        }

        public void AddStudentWithSupervisorForCompany(Student student, Supervisor supervisor)
        {
            supervisor?.Students?.Add(student);
            _context.SaveChanges();
        }

        public void RemoveStudentFromSupervisor(Student student, Supervisor? supervisor)
        {
            supervisor?.Students?.Remove(student);
            _context.SaveChanges();
        }
    }
}
