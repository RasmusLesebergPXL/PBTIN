using System;

namespace HelloOS
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello! .NET can run everywhere!");
            Console.WriteLine($"Currently, I'm running on {Environment.OSVersion}");
        }
    }
}
