using System.Windows.Controls;

namespace BalloonInterface
{
    public interface IBalloon
    {
        void ChangeSize(int diameter);
        int X { get; set; }
        void DisplayOn(Canvas drawArea);
    }
}
