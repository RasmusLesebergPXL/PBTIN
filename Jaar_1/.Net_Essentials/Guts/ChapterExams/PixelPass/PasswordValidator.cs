using System;
using System.Linq;

namespace PixelPass
{
    public class PasswordValidator
    {
        private const int MinimumLength = 5;
        private const int AverageLength = 10;

        //private const string alfabetSmallCaps = "abcdefghijklmnopqrstuvwxyz";
        //private const string alfabetUpperCaps = "ABCEDFGHIJKLMNOPQRSTUVWXYZ";
        //private const string digits = "0123456789";

        public static Strength CalculateStrength(string password)
        {
            if (password == null || password == "")
            {
                return Strength.Weak;
            } else if (password.All(char.IsUpper) ||
                       password.All(char.IsLower) ||
                       password.All(char.IsDigit) ||
                       password.Length <= MinimumLength)
            {
                return Strength.Weak;
            }
             else if (password.Any(char.IsUpper) &&
                      password.Any(char.IsLower) &&
                      password.Any(char.IsDigit) &&
                      password.Length >= AverageLength)
            {
                return Strength.Strong;
            }
            return Strength.Average;
        }
    }


    public enum Strength
    {
        Weak,
        Average,
        Strong
    }

}