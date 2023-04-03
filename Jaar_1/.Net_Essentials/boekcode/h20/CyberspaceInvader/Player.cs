using System.Windows.Controls;

namespace CyberspaceInvader
{
    public class Player : Sprite
    {
        private Image _playerImage;
        private Canvas _canvas;

        public Player()
        {
            _playerImage = new Image { Source = CreateBitmap(@"Assets\Player.gif") };

            Width = 20;
            Height = 20;
            IsDead = false;
        }

        public bool IsDead { get; set; }

        public override void DisplayOn(Canvas drawingCanvas)
        {
            X = Width / 2;
            Y = (int)drawingCanvas.Height - 2 * Width;
            drawingCanvas.Children.Add(_playerImage);
            _canvas = drawingCanvas;
        }

        public void Move(int targetX)
        {
            X = targetX;
        }

        public void ShootLaser(LaserCollection lasers)
        {
            int laserX = X + Width / 2;
            int laserY = Y - Height;
            Laser laser = new Laser(laserX, laserY, lasers);
            laser.DisplayOn(_canvas);
        }

        protected override void UpdateElement()
        {
            _playerImage.Margin = new System.Windows.Thickness(X, Y, 0, 0);
            _playerImage.Width = Width;
            _playerImage.Height = Height;
        }
    }
}
