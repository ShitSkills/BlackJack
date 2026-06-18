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
        return hand.isBust();
    }

    public boolean hasBlackJack()
    {
        return hand.hasBlackJack();
    }

    public void resetHand()
    {
        hand.clear();
    }

    public int getTotalHandValue()
    {
        return hand.getTotalValue();
    }

    public void revealHand()
    {
        hand.revealAllCards();
    }
}
