using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseArrayList
{
    public class Course
    {
        public Course(string vakNaam, string docentNaam, int aantalUren)
        {
            Vak = vakNaam;
            Docent = docentNaam;
            Uren = aantalUren;
        }
        public string Docent { get; set; }
        public string Vak { get; set; }
        public int Uren { get; set; }

        public override string ToString()
        {
            return $"Vakgegevens voor {Vak}\n" +
                    $"Docent: {Docent}\n" +
                    $"Uren: {Uren}";
        }
    }
}
