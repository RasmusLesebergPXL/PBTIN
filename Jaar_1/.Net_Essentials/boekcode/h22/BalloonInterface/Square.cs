using System.Windows.Controls;
using System.Windows.Shapes;

namespace BalloonInterface
{
    public class Square : IDisplayable
    {
        private int _x, _y;
        private int _size;
        private Rectangle _rectangle;

        public void DisplayOn(Canvas drawArea)
        {
            drawArea.Children.Add(_rectangle);
        }

        // other methods and properties
    }
}
