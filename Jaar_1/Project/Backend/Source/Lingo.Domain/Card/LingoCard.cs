using Lingo.Domain.Card.Contracts;

namespace Lingo.Domain.Card
{
    /// <inheritdoc cref="ILingoCard"/>
    internal class LingoCard : ILingoCard
    {
        public LingoCard(bool useEvenNumbers)
        {
            CardNumbers = new CardNumber[5, 5];

            Random random = new Random();
            int min = 1;
            int max = 71;

            IList<int> duplicateNumber = new List<int>();
            IList<int> alreadyCrossed = new List<int>();
            int teller = 0;

            #region Fill LingoCard w even numbers
            if (useEvenNumbers == true)
            {
                for (int row = 0; row < CardNumbers.GetLength(0); row++)
                {
                    for (int column = 0; column < CardNumbers.GetLength(1); column++)
                    {
                        int rand = random.Next(min, max);
                        while (rand % 2 == 1 || duplicateNumber.Contains(rand))
                        {
                            rand = random.Next(min, max);
                        }
                        CardNumbers[row, column] = new CardNumber(rand);
                        duplicateNumber.Add(rand);
                    }
                }
            }
            #endregion

            #region Fill LingoCard w uneven numbers
            else
            {
                for (int row = 0; row < CardNumbers.GetLength(0); row++)
                {
                    for (int column = 0; column < CardNumbers.GetLength(1); column++)
                    {
                        int rand = random.Next(min, max);
                        while (rand % 2 == 0 || duplicateNumber.Contains(rand))
                        {
                            rand = random.Next(min, max);
                        }
                        CardNumbers[row, column] = new CardNumber(rand);
                        duplicateNumber.Add(rand);
                    }
                }
            }
            #endregion

            //Randomly cross out 8 numbers
            while (teller < 8)
            {
                CardNumber cardNumber = (CardNumber) CardNumbers[random.Next(CardNumbers.GetLength(0)), random.Next(CardNumbers.GetLength(1))];

                if (!alreadyCrossed.Contains(cardNumber.Value))
                {
                    cardNumber.CrossedOut = true;
                    while (HasLingo)
                    {
                        cardNumber.CrossedOut = false;
                        cardNumber = (CardNumber)CardNumbers[random.Next(CardNumbers.GetLength(0)), random.Next(CardNumbers.GetLength(1))];
                        cardNumber.CrossedOut = true;
                        CheckForLingo();
                    }
                    if (!alreadyCrossed.Contains(cardNumber.Value))
                    {
                        alreadyCrossed.Add(cardNumber.Value);
                        teller++;
                    }           
                }
            }
        }
    
        public ICardNumber[,] CardNumbers { get; set; }

        public bool HasLingo { get => CheckForLingo(); }

        public void CrossOutNumber(int number)
        {
            for (int i = 0; i < CardNumbers.GetLength(0); i++)
            {
                for (int j = 0; j < CardNumbers.GetLength(1); j++)
                {
                    if (CardNumbers[i, j].Value == number)
                    {
                        CardNumbers[i, j].CrossedOut = true;
                    }
                }
            }
        }

        public bool CheckForLingo()
        {
            #region Horizontal Check
            for (int row = 0; row < 5; row++) {
                int teller = 0;
                for (int col = 0; col < 5; col++)
                {
                    if (CardNumbers[row, col].CrossedOut == true)
                    {
                        teller++;
                    }
                }
                if (teller == 5)
                {
                    return true;
                }
            }
            #endregion

            #region Vertical Check
            for (int row = 0; row < 5; row++)
            {
                int verticalCheck = 0;
                for (int col = 0; col < 5; col++)
                {
                    if (CardNumbers[col, row].CrossedOut == true)
                    {
                        verticalCheck++;
                    }
                }
                if (verticalCheck == 5)
                {
                    return true;
                }
            }
            #endregion

            #region Diagnoal bottom right 2 top left Check
            int diagonalTeller = 0;
            for (int i = 4; i >= 0; i--)
            {
                if (CardNumbers[i, 4 - i].CrossedOut == true)
                {
                    diagonalTeller++;
                }
                if (diagonalTeller == 5)
                {
                    return true;
                }
            }
            #endregion

            #region Diagonal top left 2 bottom right Check
            int diagonalRightTeller = 0;
            for (int i = 0; i < 5; i++)
            {
                if (CardNumbers[i, i].CrossedOut == true)
                {
                    diagonalRightTeller++;
                }
                if (diagonalRightTeller == 5)
                {
                    return true;
                }
            }
            #endregion
            return false;
        } 
    }
}