using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.Domain.Puzzle
{
    /// <inheritdoc cref="IPuzzleFactory"/>
    /// 
    internal class PuzzleFactory : IPuzzleFactory
    {
        public IWordPuzzle CreateStandardWordPuzzle(HashSet<string> wordDictionary)
        {
            Random random = new Random();
            int randomNumber  = random.Next(wordDictionary.Count);
            return new StandardWordPuzzle(wordDictionary.ElementAt(randomNumber), wordDictionary);
        }
    }
}