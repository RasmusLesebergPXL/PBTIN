using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17._7_Bankaccount
{
    public class InvalidBedragException
        : Exception
    {
        public InvalidBedragException(string message)
            : base(message)
        { }
    }
}
