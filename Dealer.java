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

    public void showFirstCard() 
    {
        
        System.out.println(getHand().getCard(0));
    
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
        return getHandValue() >= player.getHandValue();
    }
    
}
