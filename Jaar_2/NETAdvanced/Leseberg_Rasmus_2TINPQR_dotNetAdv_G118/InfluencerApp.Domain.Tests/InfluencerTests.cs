using System.Text;

namespace InfluencerApp.Domain.Tests
{
    public class InfluencerTests
    {
        private Influencer _influencer = null!;

        [SetUp]
        public void BeforeEachTest()
        {
            //TODO: make sure this method is executed before each test
            _influencer = new Influencer();
        }

        [Test]
        public void Name_Setter_Length100_ShouldSetName()
        {
            string longName = BuildLongString(100);
            _influencer.Name = longName;

            Assert.That(_influencer.Name == longName);
            //TODO: test if setting a name of 100 characters works (use the BuildLongString method to create a value to set)
        }

        public void Name_Setter_LengthMoreThan100_ShouldThrowInvalidOperationException()
        {
            string longName = BuildLongString(101);

            Assert.That(() => _influencer.Name = longName,
                Throws.TypeOf<ArgumentException>());
            //TODO: test if setting a name of 101 characters throws an exception (use the BuildLongString method to create a value to set)
        }

        private string BuildLongString(int length)
        {
            var builder = new StringBuilder();
            while (builder.Length < length)
            {
                builder.Append(Guid.NewGuid());
            }

            builder.Remove(length - 1, builder.Length - length);

            return builder.ToString();
        }
    }
}