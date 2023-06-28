namespace oef_11._2_PoolBall
{
    public class PoolBall : Ball
    {
        public void MoveUp(int amount)
        {
            _yCoord -= amount;
            Redraw();
        }

        public void MoveDown(int amount)
        {
            _yCoord += amount;
            Redraw();
        }
    }
}
