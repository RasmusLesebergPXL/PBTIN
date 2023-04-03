namespace oef_10._4_ScoreTeller
{
    public class Score
    {
        private int _getal = 1;
        private int _punten;

        public void Ophogen()
        {
            _punten += _getal;
        }

        public void Verlagen()
        {
            _punten -= _getal;
        }
        
        public int GetScore()
        {
            return _punten;
        }

        public void Reset()
        {
            _punten = 0;
        }
    }
}
