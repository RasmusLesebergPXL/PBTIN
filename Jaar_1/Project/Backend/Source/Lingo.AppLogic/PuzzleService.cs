using Lingo.AppLogic.Contracts;
using Lingo.Domain.Puzzle.Contracts;

namespace Lingo.AppLogic;

/// <inheritdoc cref="IPuzzleService"/>
internal class PuzzleService : IPuzzleService
{
    private IWordDictionaryRepository _dictionary;
    private IPuzzleFactory _puzzle;
    public PuzzleService(IWordDictionaryRepository wordDictionaryRepository, IPuzzleFactory puzzleFactory)
    {
        _dictionary = wordDictionaryRepository;
        _puzzle = puzzleFactory;
    }

    public IWordPuzzle CreateStandardWordPuzzle(int wordLength)
    {
        return _puzzle.CreateStandardWordPuzzle(_dictionary.GetWordDictionary(wordLength));
    }
}