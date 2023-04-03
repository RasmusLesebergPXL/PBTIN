using System.Windows.Controls;
using System.Windows.Media;

namespace Shapes
{
    public abstract class Shape
    {
        protected int _x;
        protected int _y;
        protected int _size = 75;
        protected SolidColorBrush brush =
            new SolidColorBrush(Colors.Black);

        public abstract void DisplayOn(Canvas drawArea);
    }
}
