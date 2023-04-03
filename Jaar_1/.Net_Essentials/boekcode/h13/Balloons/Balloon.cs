namespace Balloons
{
    public delegate void BalloonChangedEventHandler(object sender,
                                      BalloonChangedEventArgs args);

    public class Balloon
    {
        private int _x;
        private int _y;
        private int _diameter;

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
    }
}
