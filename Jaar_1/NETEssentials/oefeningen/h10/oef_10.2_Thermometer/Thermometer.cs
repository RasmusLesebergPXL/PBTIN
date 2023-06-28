namespace oef_10._2_Thermometer
{
    public class Thermometer
    {
        private int _temperature;
        private int _max;
        private int _min;

        public void SetTemperature(int temperature)
        {
            _temperature = temperature;
            if (_max < _temperature)
            {
                _max = temperature;
            }
            if (_min > _temperature)
            {
                _min = temperature;
            }
        }

        public void Reset()
        {
            _temperature = 0;
            _max = 0;
            _min = 0;
        }

        public int GetMax()
        {
            return _max;
        }

        public int GetMin()
        {
            return _min;
        }
    }
}
