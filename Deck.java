public class Deck {
    private Card[] cards;
    private int topCardIndex;

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        cards = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                cards[index++] = new Card(suit, rank);
            }
        }
        topCardIndex = 0;
    }

    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card dealCard() {
        if (topCardIndex < cards.length) {
            return cards[topCardIndex++];
        } else {
            throw new IllegalStateException("No more cards in the deck");
        }
    }
}