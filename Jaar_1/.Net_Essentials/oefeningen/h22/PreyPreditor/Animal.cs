using PreyPreditor.Contracts;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Shapes;

namespace PreyPreditor
{
    public abstract class Animal : IAnimal
    {
        private static Random _randomGenerator = new Random();
        private Ellipse _ellipse; 
        protected int _age;
        protected Color _color;
        protected Position _position;


        public Animal(int age, Color color)
        {
            _age = age;
            _color = color;
        }

        public Animal(int age, Color color, Position position)
            : base(age, color)
        {
            _position = position;
        }

        public void DisplayOn(Canvas canvas)
        {
            canvas.Children.Add(_ellipse);
        }

        public void Move()
        {
        }

        public void StopDisplaying()
        {
            
        }

        public abstract IAnimal TryBreed();

        public void UpdateDisplay()
        {
        }

        public Position Position => throw new NotImplementedException();

        public bool isDead
        {
            get => throw new NotImplementedException();
            set => throw new NotImplementedException();
        }
    }
}
