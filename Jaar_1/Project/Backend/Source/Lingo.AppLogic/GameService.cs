using Lingo.AppLogic.Contracts;
using Lingo.Domain;
using Lingo.Domain.Contracts;
using Lingo.Domain.Pit.Contracts;
using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.AppLogic
{
    /// <inheritdoc cref="IGameService"/>
    internal class GameService : IGameService
    {
        private IGameRepository _repository;
        private IGameFactory _factory;
        private IPuzzleService _service;
        private IUserRepository _userRepository;
        public GameService(IGameRepository gameRepository, IGameFactory gameFactory, IPuzzleService puzzleService, IUserRepository userRepo)
        {
            _repository = gameRepository;
            _factory = gameFactory;
            _service = puzzleService;
            _userRepository = userRepo;
        }

        public void CreateGameForUsers(User user1, User user2, GameSettings settings)
        {
            IList<IPuzzle> puzzleslist = new List<IPuzzle>();
            for(int i=0; i < settings.NumberOfStandardWordPuzzles; i++)
            {
                puzzleslist.Add(_service.CreateStandardWordPuzzle(5));//extra <---------------------------
            }
        _repository.Add(_factory.CreateStandardGameForUsers(user1, user2, puzzleslist));

        }

        public IList<IGame> GetGamesFor(Guid userId)
        {
            return _repository.GetGamesOfUser(userId);
        }

        public IGame GetById(Guid gameId)
        {
            return _repository.GetById(gameId);
        }

        public SubmissionResult SubmitAnswer(Guid gameId, Guid playerId, string answer)
        {
            return GetById(gameId).SubmitAnswer(playerId, answer);
        }

        public IBall GrabBallFromBallPit(Guid gameId, Guid playerId)
        {
            return GetById(gameId).GrabBallFromBallPit(playerId);
        }
    }
}
