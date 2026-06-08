public class Dealer {
    private List<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public String toString() {
        return "Dealer's hand: " + hand;
    }
}
