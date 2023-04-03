using System.Windows.Controls;
using System.Windows.Media;

namespace DominationGame
{
    public class Board
    {
        private Block[,] _grid; 
        public const int _size = 45;

        public Board(int row, int col)
        {
            _grid = new Block[row, col];
        }

        public void ClaimBlocks(int rowIndex, int coloumnIndex, Player player)
        {

            if (PossibleMove(rowIndex, coloumnIndex, player))
            {
                if (player == Player.Red)
                {
                    _grid[rowIndex, coloumnIndex].Owner = Player.Red;
                    _grid[rowIndex + 1, coloumnIndex].Owner = Player.Red;
                }
                else
                {
                    _grid[rowIndex, coloumnIndex].Owner = Player.Blue;
                    _grid[rowIndex, coloumnIndex + 1].Owner = Player.Blue;
                }
            } else
            {
                throw new DominationException("Move not possible");
            }
        }

        private bool PossibleMove(int rowIndex, int coloumnIndex, Player player)
        {
            if (player == Player.Red)
            {
                if (_grid[rowIndex, coloumnIndex].Owner != Player.Blue &&
                    _grid[rowIndex + 1, coloumnIndex].Owner != Player.Blue)
                {
                    return true;
                }
                return false;
            } 
            if (_grid[rowIndex, coloumnIndex].Owner != Player.Red &&
                _grid[rowIndex, coloumnIndex + 1].Owner != Player.Red)
            {
                return true;
            }
            return false;
        }
        //public bool HasMoveLeftFor(Player player)
        //{

        //}

        public void DrawBoard(Canvas canvas)
        {
            var brush = new SolidColorBrush(Colors.Black);
            int x = 10;
            int y = 10;

            for (int row = 0; row < _grid.GetLength(0); row++)
            {
                for (int column = 0; column < _grid.GetLength(1); column++)
                {
                    _grid[row, column] = new Block();
                    _grid[row, column].DrawRectangle(canvas, brush, x, y, _size, _size);
                    x += _size;
                }
                y += _size;
                x = 10;
            }
        }
    }
}
