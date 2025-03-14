package cardsCollections;

public class Card implements Comparable<Card> {
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private Suit suit;
    private CardRank cardRank;

    public Card(Suit suit, CardRank cardRank)
    {
        this.cardRank = cardRank;
        this.suit = suit;
    }

    private String convertSuit()
    {
        switch (this.suit)
        {
            case JOKER:
                return "JOKER";
            case CLUBS:
                return "\u2663";
            case DIAMONDS_:
                return "\u2666";
            case HEARTS_:
                return "\u2665";
            case SPADES:
                return "\u2660";
            default:
                return "";
        }
    }

    @Override
    public String toString()
    {
        if (this.suit.name().contains("_"))
            return String.format(RED + convertSuit() + this.cardRank + "\n");
        else
            return String.format(BLACK + convertSuit() + this.cardRank + "\n");
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
