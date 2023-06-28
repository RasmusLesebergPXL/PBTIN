using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InvalidEmailException
{
    public class InvalidEmailException
        : Exception
    {
        public InvalidEmailException(string message)
            : base(message)
        { }
    }
}
