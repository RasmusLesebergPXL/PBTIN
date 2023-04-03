using System.Collections.Generic;

namespace CyberspaceInvader
{
    public class LaserCollection
    {
        private List<Laser> _lasers = new List<Laser>();

        public void Add(Laser laser)
        {
            _lasers.Add(laser);
        }

        public void Remove(Laser laser)
        {
            _lasers.Remove(laser);
        }

        public void Move()
        {
            for (var index = 0; index < _lasers.Count; index++)
            {
                Laser laser = _lasers[index];
                laser.Move();
            }
        }

        public void CheckHit(Alien alien)
        {
            for (var index = 0; index < _lasers.Count; index++)
            {
                Laser laser = _lasers[index];
                laser.CheckHit(alien);
            }
        }
    }
}
