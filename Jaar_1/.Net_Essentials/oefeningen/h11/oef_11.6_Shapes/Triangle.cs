using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace oef_11._6_Shapes
{
    public class Triangle : Shape
    {
        public Triangle()
        {
            _xCoord = 140;
            _yCoord = 140;
            _size = 40;
        }
        public override void CreatePhysicalShape(Canvas drawingsCanvas)
        {
            Line horizontal = new Line();
            horizontal.X1 = _xCoord; horizontal.Y1 = _yCoord;
            horizontal.X2 = _xCoord + _size; horizontal.Y2 = _yCoord;
            horizontal.Stroke = new SolidColorBrush(Colors.Black);

            Line vertical = new Line();
            vertical.X1 = _xCoord; vertical.Y1 = _yCoord;
            vertical.X2 = _xCoord; vertical.Y2 = _yCoord + _size;
            vertical.Stroke = new SolidColorBrush(Colors.Black);

            Line diagonal = new Line();
            diagonal.X1 = _xCoord + _size; diagonal.Y1 = _xCoord;
            diagonal.X2 = _xCoord; diagonal.Y2 = _yCoord + _size;
            diagonal.Stroke = new SolidColorBrush(Colors.Black);

            drawingsCanvas.Children.Add(vertical);
            drawingsCanvas.Children.Add(horizontal);
            drawingsCanvas.Children.Add(diagonal);
        }

        public override void Redraw()
        {
            _xCoord = _xCoord;
            _yCoord = _yCoord;
            _size = _size;
        }
    }
}
