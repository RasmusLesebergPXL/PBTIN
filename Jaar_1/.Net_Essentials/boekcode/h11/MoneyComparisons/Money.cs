using System;
using System.Collections.Generic;
using System.Text;

namespace MoneyComparisons
{
    public struct Money
    {
        public double Amount { get; set; }
        public string Currency { get; set; }

        public Money(double amount, string currency)
        {
            Amount = amount;
            Currency = currency;
        }

        public override string ToString()
        {
            return $"Money ({Amount} {Currency})";
        }
    }
}
