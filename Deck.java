import java.util.ArrayList;
public class Deck 
{
    private ArrayList<Card> cards;
    public Deck()
    {
        cards = new ArrayList<Card>();
        createDeck();
    }

    private void createDeck()
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits)        {
            for (String rank : ranks)
            {
                cards.add(new Card(rank, suit));
            }
        }
    }
    public void shuffle()
    {
        for (int i = cards.size() - 1; i > 0; i--)
        {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
    public Card drawCard()
    {
        if (cards.isEmpty())
        {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
    
}
