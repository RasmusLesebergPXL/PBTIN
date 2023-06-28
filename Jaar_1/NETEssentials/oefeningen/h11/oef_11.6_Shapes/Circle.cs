using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace oef_11._6_Shapes
{
    public class Circle : Shape
    {
        private Ellipse _ellipse;

        public Circle()
        {
            _xCoord = 40;
            _yCoord = 40;
            _size = 80;
        }

        public override void CreatePhysicalShape(Canvas drawingsCanvas)
        {
            _ellipse = new Ellipse();
            _ellipse.Stroke = new SolidColorBrush(Colors.Black);
            _ellipse.StrokeThickness = 2;
            _ellipse.Width = _size;
            _ellipse.Height = _size;
            _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);

            drawingsCanvas.Children.Add(_ellipse);
        }

        public override void Redraw()
        {
            _ellipse.Margin = new Thickness(_xCoord, _yCoord, 0, 0);
            _ellipse.Width = _size;
            _ellipse.Height = _size;

        }


    }
}
