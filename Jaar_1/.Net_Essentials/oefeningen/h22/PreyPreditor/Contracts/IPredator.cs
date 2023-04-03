using System.Collections.Generic;

namespace PreyPreditor.Contracts
{
    public interface IPredator : IAnimal
    {
        bool canEat(IAnimal animal);

        void Hunt(IList<IAnimal> possibleVictims);
    }
}
