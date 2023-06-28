namespace PreyPreditor.Contracts
{
    public interface IAnimal : IDisplayable
    {
        Position Position { get; }
        bool isDead { get; set; }
        void Move();
        IAnimal TryBreed();

    }
}
