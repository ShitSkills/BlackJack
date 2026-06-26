public class Hand {

    private Card[] hand;

    public Hand() {
        hand = new Card[15];
    }

    public void addCard(Card card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = card;
                break;
            }
        }

    }

    public Card getCard(int index) {
        if (index >= 0 && index < hand.length) {
            return hand[index];
        }
        return null;
    }

    public int getCardCount() {
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getValue() {
        int wert = 0;
        int aces = 0;

        // Erst alle Kartenwerte addieren (nur offene Karten)
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && !hand[i].isFaceDown()) {
                wert += hand[i].getValue();
                // Zähle Aces (mit Wert 11)
                if (hand[i].getRank().equals("A")) {
                    aces++;
                }
            }
        }

        // Wenn über 21 und mindestens ein Ace vorhanden, rechne Aces als 1 statt 11 um
        while (wert > 21 && aces > 0) {
            wert -= 10; // Reduziere um 10 (11-1 pro Ace)
            aces--;
        }

        return wert;
    }

    public boolean hasBlackJack() // Falsch, da getCards() 15 zurückgibt, also ist hasBlackJack() immer false!
    {
        return getTotalValue() == 21 && getCardCount() == 2;
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public int getTotalValue() {
        // Alle Karten werten (auch verdeckte) – für finalen Vergleich
        int wert = 0;
        int aces = 0;

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                wert += hand[i].getValue();
                if (hand[i].getRank().equals("A")) {
                    aces++;
                }
            }
        }

        while (wert > 21 && aces > 0) {
            wert -= 10;
            aces--;
        }

        return wert;
    }

    public void revealAllCards() {
        // Alle verdeckten Karten aufdecken
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && hand[i].isFaceDown()) {
                hand[i].setFaceDown(false);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
    }
}
