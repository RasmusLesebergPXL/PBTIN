using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace CyberspaceInvader
{
    public class Bomb : Sprite
    {
        private int _stepSize;
        private BombCollection _bombCollection;
        private Ellipse _ellipse;
        private Canvas _canvas;
        
        public Bomb(int x, int y, BombCollection bombCollection)
        {
            _ellipse = new Ellipse {Fill = new SolidColorBrush(Colors.Black)};
            _stepSize = 5;
            _bombCollection = bombCollection;

            X = x;
            Y = y;
            Width = 5;
            Height = 5;
            
            _bombCollection.Add(this);
        }

        public override void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_ellipse);
            _canvas = drawingCanvas;
        }

        public void Move()
        {
            if (Y > _canvas.Height)
            {
                _bombCollection.Remove(this);
            }
            else
            {
                Y += _stepSize;
            }
        }

        public void CheckHit(Player player)
        {
            if (HasHit(player))
            {
                _bombCollection.Remove(this);
                player.IsDead = true;
            }
        }

        protected override void UpdateElement()
        {
            _ellipse.Width = Width;
            _ellipse.Height = Height;
            _ellipse.Margin = new Thickness(X, Y, 0, 0);
        }
    }
}
