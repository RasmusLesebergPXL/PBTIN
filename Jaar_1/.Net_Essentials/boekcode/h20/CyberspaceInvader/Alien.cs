using System.Windows;
using System.Windows.Controls;

namespace CyberspaceInvader
{
    public class Alien : Sprite
    {
        private Image _alienImage;
        private int _stepSize;
        private Canvas _canvas;
        
        public Alien()
        {
            _alienImage = new Image
            { 
                Source = CreateBitmap(@"Assets\Alien.gif")
            };
            _stepSize = 3;

            Width = 25;
            Height = 25;
            IsDead = false; 
        }

        public bool IsDead { get; set; }
        
        public override void DisplayOn(Canvas drawingCanvas)
        {
            X = Width / 2;
            Y = Height / 2;
            drawingCanvas.Children.Add(_alienImage);
            _canvas = drawingCanvas;
        }

        public void Move()
        {
            if ((X > 480) || (X < 0))
            {
                _stepSize = -_stepSize;
            }
            X += _stepSize;
        }

        public void DropBomb(BombCollection bombs)
        {
            int bombX = X + (Width / 2);
            int bombY = Y + Height;
            Bomb bomb = new Bomb(bombX, bombY, bombs);
            bomb.DisplayOn(_canvas);
        }

        protected override void UpdateElement()
        {
            _alienImage.Margin = new Thickness(X, Y, 0, 0);
            _alienImage.Width = Width;
            _alienImage.Height = Height;
        }
    }
}
