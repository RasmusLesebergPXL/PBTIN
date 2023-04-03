using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Game
{
    public class AnimalWorldPiece
    {
        private Canvas _canvas;
        private double _heigth;
        private double _width;
        private Sprite _sprite;

        public AnimalWorldPiece(Canvas canvas, double height, double width, int y, int x)
        {
            // ToDo don't forget to set the X and Y property            DONE
            X = x;
            Y = y;
            _sprite = Sprite;
            _width = width;
            _heigth = height;
            _canvas = new Canvas
            {
                Background = new SolidColorBrush(Colors.Green),
                Height = height,
                Width = width,
                Margin = new Thickness(x * width, y * height, 0, 0)
            };
            CreateBorder();
            canvas.Children.Add(_canvas);
        }

        public int X { get; set; }

        public int Y { get; set; }

        public bool ContainsFood { get; set; }

        public bool YouWereHere { get { return YouWereHere; } 
            set
            {
                RemoveFromAnimalWorldPiece();
            } 
        }

        // ToDo make the properties X, Y, ContainsFood, YouWereHere     DONE

        public Sprite Sprite
        {
            // ToDo make the property Sprite
            //      Don't forget to put the image on the Canvas, to adjust the size of the Sprite, to check if it is food       DONE

            //Kon de Null ReferenceExcep niet oplossen, sorry daarvoor.

            get { return _sprite; }
            set 
            {   
                if (_sprite.ImageName == "squirrel")
                {
                    _sprite = new Squirrel();
                }
                else if (_sprite.ImageName == "hedgehog")
                {
                    _sprite = new Hedgehog();
                }
                else if (_sprite.ImageName == "rabbit")
                {
                    _sprite = new Rabbit();
                }
                _canvas.Children.Add(_sprite.Image);
                _sprite.AdjustSize(_width, _heigth);
                
                if (_sprite is Food)
                {
                    ContainsFood = true;
                }
            }
        }

        public void RemoveFromAnimalWorldPiece()
        {
            // ToDo remove the Sprite(= the image of the sprite) from the Canvas and give the Sprite the value null         DONE
            // ToDo if the Sprite is an Animal you have to give the _canvas the color red (Don't forget the property YouWereHere)

            if (Sprite is Animal)
            {
                _canvas.Background = new SolidColorBrush(Colors.Red);
            }
            _canvas.Children.Remove(Sprite.Image);
            YouWereHere = true;
            Sprite = null;
        }

        private void CreateBorder()
        {
            Rectangle rectangle = new Rectangle
            {
                Width = _canvas.Width,
                Height = _canvas.Height,
                Stroke = new SolidColorBrush(Colors.White)
            };
            _canvas.Children.Add(rectangle);
        }
    }
}
