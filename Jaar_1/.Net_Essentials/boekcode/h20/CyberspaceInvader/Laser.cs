using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace CyberspaceInvader
{
    public class Laser : Sprite
    {
        private int _stepSize;
        private LaserCollection _laserCollection;
        private Ellipse _ellipse;
        private Canvas _canvas;

        public Laser(int x, int y, LaserCollection laserCollection)
        {
            _ellipse = new Ellipse {Fill = new SolidColorBrush(Colors.Black)};
            _stepSize = 5;
            this._laserCollection = laserCollection;

            X = x;
            Y = y;
            Width = 5;
            Height = 10;
            
            laserCollection.Add(this);
        }
        
        public override void DisplayOn(Canvas drawingCanvas)
        {
            drawingCanvas.Children.Add(_ellipse);
            _canvas = drawingCanvas;
        }

        protected override void UpdateElement()
        {
            _ellipse.Width = Width;
            _ellipse.Height = Height;
            _ellipse.Margin = new System.Windows.Thickness(X, Y, 0, 0);
        }

        public void Move()
        {
            if (Y < 0)
            {
                _laserCollection.Remove(this);
                _canvas.Children.Remove(_ellipse);
            }
            else
            {
                Y -= _stepSize;
            }
        }

        public void CheckHit(Alien alien)
        {
            if (HasHit(alien))
            {
                alien.IsDead = true;
                _laserCollection.Remove(this);
            }
        }
    }
}
