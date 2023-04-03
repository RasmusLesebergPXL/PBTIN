using System;
using System.Windows;
using System.Windows.Input;
using System.Windows.Threading;

namespace CyberspaceInvader
{
    public partial class Game : Window
    {
        private Player _player;
        private Alien _alien;

        private LaserCollection _lasers;
        private BombCollection _bombs;

        private DispatcherTimer _animationTimer;
        private DispatcherTimer _bombTimer;
        
        public Game()
        {
            InitializeComponent();

            _player = new Player();
            _player.DisplayOn(gameCanvas);

            _alien = new Alien();
            _alien.DisplayOn(gameCanvas);

            _bombs = new BombCollection();
            _lasers = new LaserCollection();

            _animationTimer = new DispatcherTimer
            {
                Interval = TimeSpan.FromMilliseconds(50)
            };
            _animationTimer.Tick += animationTimer_Tick;
            _animationTimer.Start();


            _bombTimer = new DispatcherTimer
            {
                Interval = TimeSpan.FromSeconds(2)
            };
            _bombTimer.Tick += bombTimer_Tick;
            _bombTimer.Start();
        }

        private void bombTimer_Tick(object sender, EventArgs e)
        {
            _alien.DropBomb(_bombs);
        }

        private void animationTimer_Tick(object sender, EventArgs e)
        {
            _alien.Move();
            _lasers.Move();
            _bombs.Move();
            _bombs.CheckHit(_player);
            _lasers.CheckHit(_alien);

            if (_alien.IsDead)
            {
                EndGame("player");
            }

            if (_player.IsDead)
            {
                EndGame("alien");
            }
        }

        private void gameCanvas_MouseMove(object sender, MouseEventArgs e)
        {
            var targetX = (int) (e.GetPosition(gameCanvas).X - _player.Width / 2.0);
            _player.Move(targetX);
        }

        private void gameCanvas_MouseUp(object sender, MouseButtonEventArgs e)
        {
            _player.ShootLaser(_lasers);
        }

        private void EndGame(string winner)
        {
            _animationTimer.Stop();
            _bombTimer.Stop();
            MessageBox.Show($"game over - {winner} wins");
            Environment.Exit(0);
        }
    }
}
