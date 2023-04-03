using System.Windows.Media;

namespace BalloonInterface
{
    public interface IColoredBalloon : IBalloon
    {
        void SetColor(Color c);
    }
}
