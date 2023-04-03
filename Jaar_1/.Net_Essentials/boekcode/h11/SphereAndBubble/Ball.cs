namespace SphereAndBubble
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
