using System;

namespace Exercise08
{
    public enum GenderType
    {
        Male,
        Female
    }
    public class Person
    {
        public string Name { get; set; }
        public string FirstName { get; set; }
        public GenderType Gender { get; set; }
        public string Adress { get; set; }
        public string TelephoneNumber { get; set; }     
        public DateTime BirthDate { get; set; }
        
        public override string ToString()
        {
            return $"{Name} {FirstName}";
        }
    }
}
