namespace Exercise1.FizzBuzz.AppLogic.Tests
{
    public class FizzBuzzServiceTests
    {
        private FizzBuzzService _service;
        [SetUp]

        public void BeforeEachTest()
        {
            _service = new FizzBuzzService();
        }

        [Test]
        [TestCase(2, 3, 1, "1")]
        [TestCase(4, 5, 4, "1 2 3 Fizz")]
        [TestCase(5, 4, 4, "1 2 3 Buzz")]
        [TestCase(2, 3, 15, "1 Fizz Buzz Fizz 5 FizzBuzz 7 Fizz Buzz Fizz 11 FizzBuzz 13 Fizz Buzz")]
        [TestCase(2, 2, 4, "1 FizzBuzz 3 FizzBuzz")]
        public void ReturnsCorrectFizzBuzzTextWhenParametersAreValid(int fizzFactor, int buzzFactor, int lastNumber, string expected)
        {
            var expectedString = _service.GenerateFizzBuzzText(fizzFactor, buzzFactor, lastNumber);

            Assert.That(expected, Is.EqualTo(expectedString));
        }

        [Test]
        [TestCase(1)]
        [TestCase(11)]
        public void ThrowsValidationExceptionWhenFizzFactorIsNotInRange(int fizzFactor)
        {
            Assert.That(() => _service.GenerateFizzBuzzText(fizzFactor, 3, 5), 
                Throws.TypeOf<FizzBuzzValidationException>());
        }

        [Test]
        [TestCase(1)]
        [TestCase(11)]
        public void ThrowsValidationExceptionWhenBuzzFactorIsNotInRange(int buzzFactor)
        {
            Assert.That(() => _service.GenerateFizzBuzzText(3, buzzFactor, 5),
                Throws.TypeOf<FizzBuzzValidationException>());
        }

        [Test]
        [TestCase(0)]
        [TestCase(251)]
        public void ThrowsValidationExceptionWhenLastNumberIsNotInRange(int lastNumber)
        {
            Assert.That(() => _service.GenerateFizzBuzzText(3, 5, lastNumber),
                Throws.TypeOf<FizzBuzzValidationException>());
        }
    }
}