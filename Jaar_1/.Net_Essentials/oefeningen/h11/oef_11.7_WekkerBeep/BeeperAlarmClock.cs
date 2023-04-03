using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;

namespace oef_11._7_WekkerBeep
{
    public class BeeperAlarmClock : AlarmClock
    {
        public override void Go()
        {
            SystemSounds.Beep.Play();
        }
    }
}
