import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(int numofDecks) {
        cards = new ArrayList<>();
        createDeck(numofDecks);

    }

    public void createDeck(int numofDecks) {
        String[] suits = { "Herz", "Karo", "Kreuz", "Pik" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König", "Ass" };
        for (int i = 0; i < numofDecks; i++) {
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(suit, rank));
                }
            }
        }

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

}
