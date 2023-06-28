using System;

namespace DominationGame
{
    public class DominationException
        : Exception
    {
        public DominationException(string message)
            : base(message)
        { }
    }
}
