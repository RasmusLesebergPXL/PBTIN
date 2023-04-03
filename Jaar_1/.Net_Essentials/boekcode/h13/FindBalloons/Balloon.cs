namespace FindBalloons
{
    public delegate void BalloonChangedEventHandler(object sender, BalloonChangedEventArgs args);

    public class Balloon
    {
        private int _x;
        private int _y;
        private int _diameter;

        public event BalloonChangedEventHandler BalloonChanged;

        public int Diameter { get => _diameter; set => _diameter = value; }

        public void Initialize(int newX, int newY, int newDiameter)
        {
            _x = newX;
            _y = newY;
            Diameter = newDiameter;
            BalloonChanged(this, new BalloonChangedEventArgs()
            {
                X = _x,
                Y = _y,
                Diameter = Diameter
            });
        }

        public void ChangeSize(int change)
        {
            Diameter = Diameter + change;
            BalloonChanged(this, new BalloonChangedEventArgs()
            {
                X = _x,
                Y = _y,
                Diameter = Diameter
            });
        }
    }
}
