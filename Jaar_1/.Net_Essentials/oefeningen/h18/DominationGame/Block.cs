using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace DominationGame
{
    public class Block
    {
        private Rectangle _rectangle;
        private Player _owner;

        
        public Player Owner
        {
            get { return _owner; }
            set { _owner = value; FillBlocks(); }
        }

        private void FillBlocks()
        {
            if (Owner == Player.Blue)
            {
                _rectangle.Fill = new SolidColorBrush(Colors.Blue);
            }
            else if (Owner == Player.Red)
            {
                _rectangle.Fill = new SolidColorBrush(Colors.Red);
            } 
        }

        public Block()
        {
            _rectangle = new Rectangle();
        }
        public void DrawRectangle(Canvas canvas, SolidColorBrush brush,
                                   double x, double y, int width, int height)
        {
            _rectangle = new Rectangle()
            {
                Width = width,
                Height = height,
                Margin = new Thickness(x, y, 0, 0),
                Stroke = brush
            };
            canvas.Children.Add(_rectangle);
        }
    }
}
