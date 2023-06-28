namespace oef_10._3_Bankrekening
{
    public class Bankrekening
    {
        private int _currentValue;

        public void Deposit(int addition)
        {
            _currentValue += addition;
        }
        public void Withdrawal(int withdrawal)
        {
            _currentValue -= withdrawal;
        }

        public int GetSaldo()
        {
            return _currentValue;
        }
    }

    
}
