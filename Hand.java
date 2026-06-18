public class Hand{
    
    private Card[] hand;

    public Hand()
    {
        hand = new Card[15];
    }

    public void addCard(Card card)
    {
        for(int i=0; i<hand.length; i++){
            if(hand[i] == null){
                hand[i] = card;
                break;
            }
        }

    }

    public int getCards()           //Falsch getCards() gibt 15 zurück (nicht 2), also ist hasBlackJack() immer false!
    {
        int count = 0;
        for(int i=0; i<hand.length; i++){
            if(hand[i] != null){
                count++;
            }
        }
        return count;
    }

    public int getValue(){
        int wert = 0;
        for(int i=0; i<hand.length; i++){
            wert += hand[i].getValue();
        }
        return wert;
    }

    public boolean hasBlackJack()               //Falsch, da getCards() 15 zurückgibt, also ist hasBlackJack() immer false!
    {              
        return getValue() == 21 && getCards() == 2;
    }

    public boolean isBust(){
        return getValue() > 21;
    }

    public void clear(){
        hand = new Card[0];
    }

}
