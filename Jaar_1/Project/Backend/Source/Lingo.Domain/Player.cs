using Lingo.Domain.Card.Contracts;
using Lingo.Domain.Contracts;
using Lingo.Domain.Pit.Contracts;
using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.Domain
{
    /// <inheritdoc cref="IPlayer"/>
    internal class Player : IPlayer
    {
        private int _methodTeller;
        private ILingoCardFactory _factory;
        private bool _oddOrEven;
        public Player(Guid id, string name, IBallPit ballPit, ILingoCardFactory cardFactory, bool useEvenNumbers)
        {
            Id = id;
            Name = name;
            Score = 0;
            _oddOrEven = useEvenNumbers;
            Card = cardFactory.CreateNew(_oddOrEven);
            _factory = cardFactory;
            BallPit = ballPit;
            BallPit.FillForLingoCard(Card);
        }

        public Guid Id { get; set; }

        public string Name { get; set; }

        public ILingoCard Card { get; set; }

        public IBallPit BallPit { get; set; }

        public int Score { get; set; }

        public bool CanGrabBallFromBallPit { get; set; }

        public IBall GrabBallFromBallPit()
        {
            _methodTeller++;
            IBall ball = BallPit.GrabBall();
            Card.CrossOutNumber(ball.Value);

            if (_methodTeller == 2 || ball.Type == Pit.BallType.Red)
            {
                CanGrabBallFromBallPit = false;
                _methodTeller = 0;
            }
            if (Card.HasLingo == true)
            {
                ILingoCard newCard;
                Score += 100;
                if (_oddOrEven)
                {
                    newCard = _factory.CreateNew(true);
                } else
                {
                    newCard = _factory.CreateNew(false);
                }
                BallPit.FillForLingoCard(newCard);
                CanGrabBallFromBallPit = false;
                Card = newCard;
            }
            return ball;
        }

        public void RewardForSolvingPuzzle(IPuzzle puzzle)
        {
            if (puzzle.Score != 0)
            {
                Score += 25;
            }
            if (!puzzle.IsFinished)
            {
                throw new InvalidOperationException();
            } else if (puzzle.IsFinished && Score == 0 )
            {
                CanGrabBallFromBallPit = false;
                return;
            }
            CanGrabBallFromBallPit = true;
        }
    }
}