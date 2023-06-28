using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace _17._7_Bankaccount
{
    public class BankAccount
    {
        public BankAccount(string rekeningNummer, string eigenaar, int saldo)
        {
            Rekening = rekeningNummer;
            Eigenaar = eigenaar;
            Saldo = saldo;
        }
        public string Rekening { get; set; }
        public string Eigenaar { get; set; }
        public int Saldo { get; set; }

        public void Storten(int bedrag)
        { 
            if (bedrag > 2500)
            {
                throw new InvalidBedragException($"Het bedrag {bedrag} is hoger dan maximale stortwaarde");
            }
            Saldo += bedrag;
        }

        public void Opnemen(int bedrag)
        {
            if (Saldo - bedrag > 0)
            {
                Saldo -= bedrag;
            } else
            {
                throw new InvalidBedragException($"Het bedrag {bedrag} kan niet worden opgenomen");
            }
        }
    }
}
