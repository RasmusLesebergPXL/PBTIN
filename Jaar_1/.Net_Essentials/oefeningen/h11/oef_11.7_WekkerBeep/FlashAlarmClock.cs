using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media;

namespace oef_11._7_WekkerBeep
{
    public class FlashAlarmClock : AlarmClock
    {

        private Color _color1 = Colors.White;
        private Color _color2 = Colors.Tomato;
        private SolidColorBrush _brush;

        public FlashAlarmClock( SolidColorBrush display)
        {
            _brush = display;
        }
        public override void Go()
        {
            _brush.Color = _brush.Color == _color1 ? _color2 : _color1;
        }

        public override void Reset()
        {
            base.Reset();
            _brush.Color = _color1;
        }

    }
}
