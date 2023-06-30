using InternshipsAdmin.AppLogic.Contracts;
using InternshipsAdmin.Domain;

namespace InternshipsAdmin.Infrastructure
{
    internal class StudentsRepository : IStudentsRepository
    {
        private InternshipsContext _context;
      
        public StudentsRepository(InternshipsContext context)
        {
            _context = context;
        }
        public ICollection<Student> GetAll()
        {
            return _context.Students.ToList();
        }

        public ICollection<Student> GetStudentsWithoutSupervisor()
        {
            var studentQuery =
                (from student in _context.Students
                 where student.Supervisor == null
                 select student).ToList();

            return studentQuery;
        }
    }
}
