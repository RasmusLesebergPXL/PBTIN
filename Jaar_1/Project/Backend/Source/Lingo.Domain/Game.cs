using Lingo.Domain.Contracts;
using Lingo.Domain.Pit.Contracts;
using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.Domain
{
    /// <inheritdoc cref="IGame"/>
    internal class Game : IGame
    {
        public Game(IPlayer player1, IPlayer player2, IList<IPuzzle> puzzles)
        {
            Id = Guid.NewGuid();
            Player1 = player1;
            Player2 = player2;
            PlayerToPlayId = Player1.Id;
            CurrentPuzzle = puzzles[0];
            ListOfPuzzles = puzzles;
        }

        public Guid Id { get; set; }

        public IPlayer Player1 { get; set; }

        public IPlayer Player2 { get; set; }

        public Guid PlayerToPlayId { get; set; }

        public IList<IPuzzle> ListOfPuzzles { get; set; }

        public IPuzzle CurrentPuzzle { get; set; }

        public bool Finished { get => TestFinish(); }

        public IBall GrabBallFromBallPit(Guid playerId)
        {
            if (PlayerToPlayId != playerId)
            {
                throw new ApplicationException("speler niet aan de beurt");
            }

            if (Player1.Id == playerId)
            {
                if (!Player1.CanGrabBallFromBallPit)
                {
                    throw new ApplicationException("speler mag geen bal trekken");
                }
                IBall ball = Player1.GrabBallFromBallPit();
                if (ball.Type == Pit.BallType.Red)
                {
                    PlayerToPlayId = Player2.Id;
                }
                if (!Player1.CanGrabBallFromBallPit)
                {
                    NextPuzzle();
                    TestFinish();
                }
                Player1.Card.CrossOutNumber(ball.Value);
                return ball;
            }
            else
            {
                if (!Player2.CanGrabBallFromBallPit)
                {
                    throw new ApplicationException("speler mag geen bal trekken");
                }
                IBall playerTwoball = Player2.GrabBallFromBallPit();
                if (playerTwoball.Type == Pit.BallType.Red)
                {
                    PlayerToPlayId = Player1.Id;
                }
                if (!Player2.CanGrabBallFromBallPit)
                {
                    NextPuzzle();
                    TestFinish();
                }
                Player2.Card.CrossOutNumber(playerTwoball.Value);
                return playerTwoball;
            }
        }
        private bool TestFinish()
        {
            if (ListOfPuzzles[ListOfPuzzles.Count - 1].IsFinished 
                && !Player1.CanGrabBallFromBallPit && !Player2.CanGrabBallFromBallPit)
            {
                return true;
            }
            return false;
        }
        private void NextPuzzle()
        {
            if (TestFinish()) { return; }

            int index = ListOfPuzzles.IndexOf(CurrentPuzzle);
            if (index + 1 < ListOfPuzzles.Count)
            {
                CurrentPuzzle = ListOfPuzzles[index + 1];
            }
        }

        public SubmissionResult SubmitAnswer(Guid playerId, string answer)
        {
            if (PlayerToPlayId != playerId)
            {
                throw new ApplicationException("speler niet aan de beurt");
            }
            if (CurrentPuzzle.IsFinished == true)
            {
                throw new ApplicationException("spel is beëindigd");
            }

            SubmissionResult result = CurrentPuzzle.SubmitAnswer(answer);

            if (!result.LostTurn)
            {   
                if (CurrentPuzzle.IsFinished)
                {
                    if (PlayerToPlayId == Player1.Id)
                    {
                        Player1.RewardForSolvingPuzzle(CurrentPuzzle);
                        if (Player1.Score == 0)
                        {
                            CurrentPuzzle.RevealPart();
                            NextPuzzle();
                        }
                    }
                    else
                    {
                        Player2.RewardForSolvingPuzzle(CurrentPuzzle);
                        if (Player2.Score == 0)
                        {
                            CurrentPuzzle.RevealPart();
                            NextPuzzle();
                        }
                    }
                }
                return result;             
            }
            CurrentPuzzle.RevealPart();
            if (PlayerToPlayId == Player1.Id)
            {
                PlayerToPlayId = Player2.Id;
            }
            else
            {
                PlayerToPlayId = Player1.Id;
            }
            return result;
        }
    }
}