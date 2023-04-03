using Lingo.Domain.Card;
using Lingo.Domain.Card.Contracts;
using Lingo.Domain.Contracts;
using Lingo.Domain.Pit;
using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.Domain
{
    internal class GameFactory : IGameFactory
    {
        private ILingoCardFactory _card;
        public GameFactory(ILingoCardFactory cardFactory)
        {
            _card = cardFactory;
        }

        public IGame CreateStandardGameForUsers(User user1, User user2, IList<IPuzzle> puzzles)
        {
            bool useEvenNumbers = true;
            bool useOddNumbers = false;
            Player player1 = new Player(user1.Id, user1.NickName, new BallPit(), _card, useEvenNumbers);
            Player player2 = new Player(user2.Id, user2.NickName, new BallPit(), _card, useOddNumbers);

            if (player1.Id != player2.Id)
            {
                return new Game(player1, player2, puzzles);
            } 
            throw new ApplicationException();
        }
    }
}