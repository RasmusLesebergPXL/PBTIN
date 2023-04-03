using System.Collections.Generic;

namespace CyberspaceInvader
{
    public class BombCollection
    {
        private List<Bomb> _bombs = new List<Bomb>();

        public void Add(Bomb bomb)
        {
            _bombs.Add(bomb);
        }

        public void Remove(Bomb bomb)
        {
            _bombs.Remove(bomb);
        }

        public void Move()
        {
            for (var index = 0; index < _bombs.Count; index++)
            {
                Bomb bomb = _bombs[index];
                bomb.Move();
            }
        }

        public void CheckHit(Player player)
        {
            for (var index = 0; index < _bombs.Count; index++)
            {
                Bomb bomb = _bombs[index];
                bomb.CheckHit(player);
            }
        }
    }
}
