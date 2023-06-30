using System;
using System.Collections;
using System.Collections.Generic;

namespace Exercise2
{
    public class StudentAdministration : IStudentAdministration
    {
        private readonly IList<Student> _students = new List<Student>();

        public int StudentTotal { get; set; }

        public event NewStudentDelegate? NewStudent;

        public void RegisterStudent(Student student)
        {
            _students.Add(student);

            StudentEventArgs args = new(student);
            NewStudent?.Invoke(student, args);
        }

    }
}
