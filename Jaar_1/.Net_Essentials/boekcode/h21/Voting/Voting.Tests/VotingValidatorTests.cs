using NUnit.Framework;
using System;

namespace Voting.Tests
{
    class VotingValidatorTests
    {
        [Test]
        public void CheckWhenOlderThan17_ReturnTrue()
        {
            // Arrange
            VotingValidator validator = new VotingValidator();
            int age = 41;
            bool expectedOutcome = true;

            // Act
            bool actualOutcome = validator.Check(age);

            // Assert
            Assert.AreEqual(expectedOutcome, actualOutcome);
        }

        [Test]
        public void CheckWhenYoungerThan17_ReturnsFalse()
        {
            // Arrange
            VotingValidator validator = new VotingValidator();
            int age = 6;
            bool expectedOutcome = false;

            // Act
            bool actualOutcome = validator.Check(age);

            // Assert
            Assert.AreEqual(expectedOutcome, actualOutcome);
        }

        [Test]
        public void CheckWhenNegativeAge_ThrowsArgumentOutOfRangeException()
        {
            // Arrange
            VotingValidator validator = new VotingValidator();
            int age = -20;

            // Act and Assert
            Assert.Throws<ArgumentOutOfRangeException>(() => validator.Check(age));
        }
    }
}
