using System;

namespace Game
{
    internal class MoveException
        : Exception
    {
        public MoveException(string message) 
            :base(message) { }
    }
}
