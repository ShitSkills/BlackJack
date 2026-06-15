public class Player 
{
    private String name;
    private Hand hand;

    public Player(String name) 
    {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() 
    {
        return name;
    }

    public Hand getHand()
    {
        return hand;
    }

    public void takeCard(Card card)
    {
        hand.addCard(card);
    }

    public int getHandValue()
    {
        return hand.getValue();
    }

    public boolean isBusted()
    {
        return getHandValue() > 21;
    }

    public boolean hasBlackJack()
    {
        return getHandValue() == 21 && hand.getCards().size() == 2;
    }

    public void resetHand()
    {
        hand.clear();
    }
}
