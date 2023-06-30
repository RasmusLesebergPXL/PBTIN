using System.Text;

namespace Exercise1.FizzBuzz.AppLogic;

public class FizzBuzzService : IFizzBuzzService
{
    public const int MinimumFactor = 2;
    public const int MaximumFactor = 10;
    public const int MinimumLastNumber = 1;
    public const int MaximumLastNumber = 250;

    public string GenerateFizzBuzzText(int fizzFactor, int buzzFactor, int lastNumber)
    {
        Validate(fizzFactor, buzzFactor, lastNumber);

        StringBuilder builder = new();

        int i = 1;
        while (i <= lastNumber)
        {
            if (i % fizzFactor == 0 && i % buzzFactor == 0)
            {
                builder.Append("FizzBuzz ");
            }
            else if (i % fizzFactor == 0)
            {
                builder.Append("Fizz ");
            }
            else if (i % buzzFactor == 0)
            {
                builder.Append("Buzz ");
            }
            else { builder.Append(i + " "); }
            i++;
        }
        return builder.ToString().Trim();
    }

    public void Validate(int fizzFactor, int buzzFactor, int lastNumber)
    {
        if (fizzFactor < MinimumFactor || fizzFactor > MaximumFactor ||
            buzzFactor < MinimumFactor || buzzFactor > MaximumFactor ||
            lastNumber < MinimumLastNumber || lastNumber > MaximumLastNumber)
        {

            throw new FizzBuzzValidationException("Invalid input");
        }
        else
        {
            return;
        }
    }
}