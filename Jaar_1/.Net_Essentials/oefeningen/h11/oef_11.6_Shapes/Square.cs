using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Ink;
using System.Windows.Media;

namespace oef_11._6_Shapes
{
    public class Square : Shape
    {
        private Rectangle _square;

        public Square()
        {
            _xCoord = 20;
            _yCoord = 340;
            _size = 50;
        }

        public override void CreatePhysicalShape(Canvas drawingsCanvas)
        {
            _square = new Rectangle();
            _square.Stroke = SolidColorBrush(Colors.Black);
            _square.StrokeThickness = 2;
            _square.Width = _size;
            _square.Height = _size;

            drawingsCanvas.Children.Add(_square);
        }

        public override void Redraw()
        {
            _square.Width = _size;
            _square.Height = _size;

        }
    }
}
