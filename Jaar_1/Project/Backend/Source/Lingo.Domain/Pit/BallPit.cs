using Lingo.Domain.Card.Contracts;
using Lingo.Domain.Pit.Contracts;

namespace Lingo.Domain.Pit
{
    /// <inheritdoc cref="IBallPit"/>
    internal class BallPit : IBallPit
    {
        private IList<IBall> _list;
        public BallPit()
        {
            _list = new List<IBall>();
        }

        public void FillForLingoCard(ILingoCard lingoCard)
        {
            _list.Clear();
            for (int i = 0; i < 3; i++)
            {
                _list.Add(new Ball(BallType.Red, 1));
            }

            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    ICardNumber cardNumber = lingoCard.CardNumbers[i, j];
                    if (!cardNumber.CrossedOut)
                    {
                        _list.Add(new Ball(BallType.Blue, cardNumber.Value));
                    }
                }
            }
        }


        public IBall GrabBall()
        {
            Random randomPick = new Random();
            int index = randomPick.Next(_list.Count);
            IBall ball = _list[index];

            if (ball.Type == BallType.Blue)
            {
                _list.RemoveAt(index);
            }
            return ball;
        }
    }
}