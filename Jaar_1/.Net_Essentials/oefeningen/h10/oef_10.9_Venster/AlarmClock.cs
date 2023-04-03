using System;

namespace oef_10._9_Venster
{
    public class AlarmClock
    {
        private static DateTime _alarmTime = new DateTime();
        private static DateTime _currentTime = new DateTime();
        private int _beepTimeInSeconds;

        public AlarmClock()
        {
            _beepTimeInSeconds = 10;
        }
        public string GetTime()
        {
            return Convert.ToString(_alarmTime.ToString("HH:mm:ss"));
        }
        public void SetAlarm(string newAlarmTime)
        {
            DateTime alarm = DateTime.ParseExact(newAlarmTime, "HH:mm:ss", null);
            _alarmTime = Convert.ToDateTime(alarm);
        }

        public bool IsAlarmPassed()
        {
            _currentTime = DateTime.Now;

            int result = DateTime.Compare(_currentTime, _alarmTime);

            if (_alarmTime == DateTime.MinValue)
            {
                return false;
            }
            else if (result < 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public bool ShouldStopBeeping()
        {
            int result = DateTime.Compare(_currentTime, _alarmTime.AddSeconds(_beepTimeInSeconds));

            if (_alarmTime == DateTime.MinValue)
            {
                return false;
            }
            else if (result < 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public void Reset()
        {
            _alarmTime = DateTime.MinValue;
        }

        public void AddSeconds(int seconds)
        {
            _beepTimeInSeconds += seconds;
        }
    }
}
