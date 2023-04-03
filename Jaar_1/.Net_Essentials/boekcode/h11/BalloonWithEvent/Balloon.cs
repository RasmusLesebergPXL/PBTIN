namespace BalloonWithEvent
{
    public delegate void BalloonChangedEventHandler(int x, int y, int diameter);

    public class Balloon
    {
        private int _x = 50;
        private int _y = 50;
        private int _diameter = 20;

        public event BalloonChangedEventHandler BalloonChanged;

        public void Initialize(int newX, int newY, int newDiameter)
        {
            _x = newX;
            _y = newY;
            _diameter = newDiameter;
            BalloonChanged(_x, _y, _diameter);
        }

        public void MoveRight(int xStep)
        {
            _x = _x + xStep;
            BalloonChanged(_x, _y, _diameter);
        }

        public void ChangeSize(int change)
        {
            _diameter = _diameter + change;
            BalloonChanged(_x, _y, _diameter);
        }

        public int XCoord
        {
            get
            {
                return _x;
            }
            set
            {
                _x = value;
                BalloonChanged(_x, _y, _diameter);
            }
        }

        public int YCoord
        {
            get
            {
                return _y;
            }
            set
            {
                _y = value;
                BalloonChanged(_x, _y, _diameter);
            }
        }
    }
}
