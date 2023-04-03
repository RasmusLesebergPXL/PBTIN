using System;

namespace BalloonWithDelegate
{
    public delegate void BalloonDisplayer(int x, int y, int diameter);

    public class Balloon
    {
        private int _x = 50;
        private int _y = 50;
        private int _diameter = 20;

        public BalloonDisplayer Display;

        public void Initialize(int newX, int newY, int newDiameter)
        {
            _x = newX;
            _y = newY;
            _diameter = newDiameter;
            Display(_x, _y, _diameter);
        }

        public void MoveRight(int xStep)
        {
            _x = _x + xStep;
            Display(_x, _y, _diameter);
        }

        public void ChangeSize(int change)
        {
            _diameter = _diameter + change;
            Display(_x, _y, _diameter);
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
                Display(_x, _y, _diameter);
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
                Display(_x, _y, _diameter);
            }
        }
    }
}
