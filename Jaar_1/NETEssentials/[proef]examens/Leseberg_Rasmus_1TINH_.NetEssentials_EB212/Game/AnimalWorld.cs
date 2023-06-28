using System.Windows.Controls;

namespace Game
{
    public class AnimalWorld
    {
        private AnimalWorldPiece[,] _world;
        public int FoodCount { get; set; }

        public AnimalWorld(Canvas canvas, int rows, int columns)
        {
            _world = new AnimalWorldPiece[rows, columns];
            double width = canvas.Width / columns;
            double height = canvas.Height / rows;
            CreateAnimalWorldPieces(canvas, width, height);
        }

        private void CreateAnimalWorldPieces(Canvas canvas, double width, double height)
        {
            for (int i = 0; i < _world.GetLength(0); i++)
            {
                for (int j = 0; j < _world.GetLength(1); j++)
                {
                    _world[i, j] = new AnimalWorldPiece(canvas, height, width, i, j);
                }
            }
        }

        public void AddSpriteToWorld(Sprite sprite, int columnNumber, int rowNumber)
        {// ToDo set the property Sprite of the right element of _world
         // ToDo set the X and Y property of the Sprite                 DONE

            _world[columnNumber -1, rowNumber -1].Sprite = sprite;
            sprite.X = columnNumber;
            sprite.Y = rowNumber;
        }

        public void Move(Sprite sprite, int dX, int dY) // dX stepSize in x direction, dY stepSize in y direction
        {
            // ToDo check if the move is possible. If not => throw a MoveException          
            if (sprite.X - dX < 0)
            {
                throw new MoveException("Je bent aan de linkerkant");
            }
            else if (sprite.X + dX > _world.GetLength(0))
            {
                throw new MoveException("Je bent aan de rechterkant");
            }
            else if (sprite.Y + dY > _world.GetLength(1))
            {
                throw new MoveException("Je bent aan de onderkant");
            }
            else if (sprite.Y - dY < 0)
            {
                throw new MoveException("Je bent aan de bovenkant");
            }
            // ToDo check if the player has been on this location. If yes => throw a MoveException

            else if (_world[dX, dY].YouWereHere)
            {
                throw new MoveException("Je bent hier al eens geweest");
            }
            // ToDo if the move is possible: check if there is food on the new position.
            //      Remove the food from this position and change the value of the FoodCount property

            if (_world[dX, dY].ContainsFood)
            {
                _world[dX, dY].YouWereHere = true;
                FoodCount++;
            }
            // ToDo Don't forget to remove the worldobject from the old position and place it on the new position

            _world[sprite.X, sprite.Y] = _world[sprite.X + dX, sprite.Y + dY];
        }
    }
}
