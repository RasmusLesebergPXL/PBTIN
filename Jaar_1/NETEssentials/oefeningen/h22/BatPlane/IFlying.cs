namespace ExampleInterface
{
    public interface IFlying : IDrawable
    {
        int Mps { get; }
        void Fly();
        void Land();
    }
}
