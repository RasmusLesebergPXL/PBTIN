using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace oef_11._6_Shapes
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

        public abstract void CreatePhysicalShape(Canvas drawingsCanvas);

        public abstract void Redraw();
    }
}
