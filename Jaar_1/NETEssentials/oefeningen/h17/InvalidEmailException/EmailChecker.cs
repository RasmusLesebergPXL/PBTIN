using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace InvalidEmailException
{
    public class EmailChecker
    {
        public void CheckAddress(string address)
        {
            if (address.Contains('@')) 
            {
                MessageBox.Show("Success");
            } else
            {
                throw new InvalidEmailException($"{address} does not contain @-sign!");
            }
        }
    }
}
