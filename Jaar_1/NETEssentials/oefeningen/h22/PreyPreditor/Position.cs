namespace PreyPreditor.Contracts
{
    public class Position
    {
        private int _x;
        private int _y;

        public int X
        {
            get { return _x; }
            set
            {
                if (value < 0)
                {
                    _x = 0;
                }
                else if (value > 15)
                {
                    _x = 15;
                }
            }
        }

        public int Y
        {
            get { return _y; }
            set
            {
                if (value < 0)
                {
                    _y = 0;
                }
                else if (value > 15)
                {
                    _y = 15;
                }
            }
        }

        public void MoveUp()
        {
            Y++;
        }

        public void MoveDown()
        {
            Y--;
        }

        public void MoveRight()
        {
            X++;
        }

        public void MoveLeft()
        {
            X--;
        }
    }
}
