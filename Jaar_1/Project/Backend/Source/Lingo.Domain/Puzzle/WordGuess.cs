namespace Lingo.Domain.Puzzle
{
    /// <summary>
    /// A guess made in a word puzzle.
    /// Contains the guessed word and the letter matches compared to the solution
    /// </summary>
    public class WordGuess
    {
        /// <summary>
        /// The guessed word.
        /// </summary>
        public string Word { get; }

        /// <summary>
        /// Matches of the letters in the guessed <see cref="Word"/> compared to the solution.
        /// Each letter gets one of the following values:
        /// 1 (Correct): the letter matches exactly with the letter in the solution on the same position.
        /// 0 (CorrectButInWrongPosition): the letter occurs in the solution but on a different position (and is not yet matched with a letter in the solution on the correct position).
        /// -1 (DoesNotOccur): the letter does not occur on any position in the solution. 
        /// </summary>
        public LetterMatch[] LetterMatches { get; }

        public WordGuess(string word, string solution)
        {
            Word = word;
            LetterMatches = new LetterMatch[Word.Length];
            IList<char> matchedLetters = new List<char>();
            IList<char> correctLetters = new List<char>();


            if (Word.Length != solution.Length)
            {
                throw new ArgumentException("de lengte van het woord is niet juist");
            }

            for (int i = 0; i < solution.Length; i++)
            {
                if (solution[i] == Word[i])
                {
                    LetterMatches[i] = LetterMatch.Correct;
                    correctLetters.Add(Word[i]);
                }

                else if (solution[i] != Word[i] && !solution.Contains(Word[i]))
                {
                    LetterMatches[i] = LetterMatch.DoesNotOccur;
                }

                else if (solution[i] != Word[i] && solution.Contains(Word[i]))
                {
                    if (matchedLetters.Contains(Word[i]))
                    {
                        LetterMatches[i] = LetterMatch.DoesNotOccur;
                    }
                    else if (Word.LastIndexOf(Word[i]) == solution.IndexOf(Word[i]))
                    {
                        LetterMatches[i] = LetterMatch.DoesNotOccur;
                    }
                    else if (correctLetters.Contains(Word[i]) && CheckOccurrence(Word, Word[i])
                             > CheckOccurrence(solution, Word[i]))
                    {
                        LetterMatches[i] = LetterMatch.DoesNotOccur;
                    }
                    else
                    {
                        LetterMatches[i] = LetterMatch.CorrectButInWrongPosition;
                        matchedLetters.Add(Word[i]);
                    }
                }
            } 
        }

        public int CheckOccurrence(string word, char character)
        {
            int counter = 0;
            for (int i = 0; i < word.Length; i++)
            {
                if (word[i] == character)
                {
                    counter++;
                }
            }
            return counter;
        }
    }
}