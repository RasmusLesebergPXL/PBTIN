using Lingo.Domain.Pit.Contracts;

namespace Lingo.Domain.Pit
{
    /// <inheritdoc cref="IBall"/>
    internal class Ball : IBall
    {
        public Ball(BallType type, int value = 0)
        {
            Type = type;
            Value = value;
        }

        public int Value { get; }

        public BallType Type { get; }
    }

}