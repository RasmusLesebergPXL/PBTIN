namespace BalloonWithEventConvention
{
    public delegate void BalloonChangedEventHandler(object sender, BalloonChangedEventArgs args);

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
            BalloonChanged(this, new BalloonChangedEventArgs()
            {
                X = _x,
                Y = _y,
                Diameter = _diameter
            });
        }

        public void MoveRight(int xStep)
        {
            _x = _x + xStep;
            BalloonChanged(this, new BalloonChangedEventArgs()
            {
                X = _x,
                Y = _y,
                Diameter = _diameter
            });
        }

        public void ChangeSize(int change)
        {
            _diameter = _diameter + change;
            BalloonChanged(this, new BalloonChangedEventArgs()
            {
                X = _x,
                Y = _y,
                Diameter = _diameter
            });
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
                BalloonChanged(this, new BalloonChangedEventArgs()
                {
                    X = _x,
                    Y = _y,
                    Diameter = _diameter
                });
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
                BalloonChanged(this, new BalloonChangedEventArgs()
                {
                    X = _x,
                    Y = _y,
                    Diameter = _diameter
                });
            }
        }
    }
}
