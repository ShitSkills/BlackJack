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
        // Erste Karte offen
        takeCard(deck.drawCard());
        
        // Zweite Karte verdeckt
        Card secondCard = deck.drawCard();
        secondCard.setFaceDown(true);
        takeCard(secondCard);
    }

    public boolean beats(Player player) 
    {
        // Nutze getTotalHandValue() für finalen Vergleich (mit allen Karten)
        int dealerValue = getTotalHandValue();
        int playerValue = player.getTotalHandValue();
        
        if (dealerValue > 21) 
        {
            return false; 
        }
        if (playerValue > 21) 
        {
            return true; 
        }
        return dealerValue > playerValue;
    }
    
}
