using Lingo.Domain.Card.Contracts;

namespace Lingo.Domain.Card;

/// <inheritdoc cref="ILingoCardFactory"/>
internal class LingoCardFactory : ILingoCardFactory
{
    public ILingoCard CreateNew(bool useEvenNumbers)
    {
        LingoCard card = new LingoCard(useEvenNumbers);
        return card;
    }
}