using Lingo.Domain.Puzzle.Contracts;
using System.Diagnostics;
using System.Linq;

namespace Lingo.Domain.Puzzle
{
    /// <summary>
    /// Puzzle in which letters of a word to be solved, are revealed.
    /// When all letters are revealed the puzzle is solved.
    /// Multiple guesses can be made to solve the puzzle.
    /// </summary>
    /// <inheritdoc cref="IWordPuzzle"/>
    internal class StandardWordPuzzle : IWordPuzzle
    {
        /// <summary>
        /// Constructs a word puzzle
        /// </summary>
        /// <param name="solution">The solution of the puzzle</param>
        /// <param name="wordDictionary">The dictionary of words that should be used to verify submitted answers</param>
        /// 
        private string _solution;
        private HashSet<string> _dictionary;
        private List<WordGuess> _guesses;
        public StandardWordPuzzle(string solution, HashSet<string> wordDictionary)
        {
            _solution = solution;
            _dictionary = wordDictionary;
            _guesses = new List<WordGuess>();
            Id = Guid.NewGuid();
            Type = "StandardWordPuzzle";
            WordLength = _solution.Length;

            RevealedLetters = new char[WordLength];
            char firstLetter = _solution[0];
            RevealedLetters[0] = firstLetter;
            for (int i = 1; i < WordLength; i++)
            {
                RevealedLetters[i] = '.';
            }

            Debug.WriteLine("Solution is: " + _solution);
        }
        public IReadOnlyList<WordGuess> Guesses { get { return _guesses; } }

        public int WordLength { get; set; }

        public char[] RevealedLetters { get; }

        public Guid Id { get; set; }

        public bool IsFinished { get; set; }

        public string Type { get; set; }

        public int Score
        {
            get { return CalculateScore(); }
        }

        public void RevealPart()
        {
            if (Guesses.Count == 6)
            {
                RevealSolution();
                return;
            }
            int index = 0;
            int count = RevealedLetters.Count(f => f == '.');
            for (int i = 0; i < RevealedLetters.Length; i++)
            {
                if (RevealedLetters[i] == '.' && i < 4)
                {
                    index = i;
                    break;
                }
                else if (count == 1)
                {
                    return;
                }
            }
            RevealedLetters[index] = _solution[index];
        }

        public SubmissionResult SubmitAnswer(string answer)
        {
            string upperAnswer = answer.ToUpper();

            if (upperAnswer.Length != _solution.Length)
            {
                return SubmissionResult.CreateLoseTurnResult("Het woord is niet 5 letters lang");
            }
            else if (!_dictionary.Contains(upperAnswer))
            {
                return SubmissionResult.CreateLoseTurnResult($"{upperAnswer} bestaat niet in het woordenboek");
            }
            WordGuess guess = new(upperAnswer, _solution);
            _guesses.Add(guess);

            if (Guesses.Count >= 5 && upperAnswer != _solution)
            {
                if (Guesses.Count == 6)
                {
                    IsFinished = true;
                    return SubmissionResult.CreateKeepTurnResult();
                }
                return SubmissionResult.CreateLoseTurnResult("U heeft geen pogingen meer");
            }
            if (upperAnswer == _solution)
            {
                RevealSolution();
                IsFinished = true;
                return SubmissionResult.CreateKeepTurnResult();
            }
            RevealCorrectLetters();
            return SubmissionResult.CreateKeepTurnResult();
        }

        private int CalculateScore()
        {
            string str = new string(RevealedLetters);
            if (str == _solution)
            {
                return 25;
            }
            return 0;
        }

        private void RevealSolution()
        {
            for (int i = 0; i < _solution.Length; i++)
            {
                RevealedLetters[i] = _solution[i];
            }
        }

        private void RevealCorrectLetters()
        {
            WordGuess guess = Guesses.ElementAt(Guesses.Count - 1);

            for (int i = 0; i < _solution.Length; i++)
            {
                if (guess.LetterMatches[i] == LetterMatch.Correct)
                {
                    RevealedLetters[i] = _solution[i];
                }
            }
        }
    }
}