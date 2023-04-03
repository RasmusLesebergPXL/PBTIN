namespace oef_11._2_PoolBall
{
    public class Ball : Sphere
    {
        public void MoveLeft(int amount)
        {
            _xCoord -= amount;
            Redraw();
        }

        public void MoveRight(int amount)
        {
            _xCoord += amount;
            Redraw();
        }
    }
}
