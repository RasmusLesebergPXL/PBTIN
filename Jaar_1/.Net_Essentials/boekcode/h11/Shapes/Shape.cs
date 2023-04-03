using System.Windows.Controls;

namespace Shapes
{
    public abstract class Shape
    {
        protected int _xCoord, _yCoord;
        protected int _size;

        public void MoveRight()
        {
            _xCoord += 10;
            Redraw();
        }

        public abstract void CreatePhysicalShape(Canvas drawingCanvas);

        public abstract void Redraw();
    }
}
