using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace oef_11._3_Bankrekening
{
    public class NormalRekening
    {
        private double _currentBalance;
        private int _rente;

        public double CurrentBalance
        {
            get { return _currentBalance; }
        }

        public bool Credit()
        {
            if (_currentBalance >= 1000)
            {
                return true;
            }
            return false;
        }

        public double CalculateInterest()
        {
            if (_currentBalance >= 100)
            {
                return _currentBalance / 100;
            }
            return 0;
        }
    }
}
