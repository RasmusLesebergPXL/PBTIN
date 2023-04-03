using System.Windows.Controls;

namespace PreyPreditor.Contracts
{
    public interface IDisplayable
    {
        void DisplayOn(Canvas canvas);
        void StopDisplaying();
        void UpdateDisplay();
    }
}
