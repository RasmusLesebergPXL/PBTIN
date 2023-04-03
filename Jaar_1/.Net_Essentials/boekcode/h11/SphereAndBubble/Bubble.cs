using System.Windows;

namespace SphereAndBubble
{
    public class Bubble : Sphere
    {
        protected int _radius = 60;

        public int Size
        {
            set { _radius = value; Redraw(); }
        }

        public /*override*/ void Redraw()
        {
            if (_ellipse != null)
            {
                _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
                _ellipse.Width = 2 * _radius;
                _ellipse.Height = 2 * _radius;
            }
        }

        public void MoveVertical(int amount)
        {
            _yCoord += amount;
            Redraw();
        }
    }
}
