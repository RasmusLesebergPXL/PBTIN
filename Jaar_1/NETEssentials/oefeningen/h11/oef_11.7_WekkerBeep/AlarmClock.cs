using System;

namespace oef_11._7_WekkerBeep
{
    public abstract class AlarmClock
    {
        private DateTime _alarmTime;
        private int _beepTimeInSeconds;

        public AlarmClock()
        {
            _beepTimeInSeconds = 10;
        }
        public string CurrentTime => DateTime.Now.ToLongTimeString();

        public string AlarmTime
        {
            set { _alarmTime = Convert.ToDateTime(value); }
        }

        public bool IsAlarmPassed()
        {
            if (_alarmTime == DateTime.MinValue)
            {
                return false;
            }
            return DateTime.Now > _alarmTime;
        }

        public bool ShouldStopBeeping()
        {
            if (IsAlarmPassed())
            {
                return DateTime.Now > _alarmTime.AddSeconds(_beepTimeInSeconds);
            }
            return false;
        }

        public virtual void Reset()
        {
            _alarmTime = DateTime.MinValue;
        }

        public abstract void Go();
    }
}
