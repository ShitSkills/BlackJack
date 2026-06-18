public class Dealer extends Player 
{
    public Dealer() 
    {
        super("Dealer");
    }

    public void play(Deck deck) 
    {
        while (getHandValue() < 17) 
        {
            takeCard(deck.drawCard());
        }
    }

    public void dealerDeal(Deck deck) {
    // Erste Karte normal
    takeCard(deck.drawCard());
    // Zweite Karte verdeckt
    Card secondCard = deck.drawCard();
    secondCard.setFaceDown(true);  // ← Oder via Hand
    takeCard(secondCard);
}

    public boolean beats(Player player) 
    {
        if (getHandValue() > 21) 
        {
            return false; 
        }
        if (player.getHandValue() > 21) 
        {
            return true; 
        }
        return getHandValue() > player.getHandValue();
    }
    
}
