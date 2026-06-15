public class Hand{
    
    private Card[] hand;

    public Hand(Card[] hand){
        this.hand = hand;
    }

    public void addCard(Card card){

    }

    public int getCards(){
        return hand.length;
    }

    public int getValue(){
        int wert = 0;
        for(int i=0; i<hand.length; i++){
            wert += hand[i].getValue();
        }
        return wert;
    }

    public boolean hasBlackJack(){
        return getValue() == 21 && getCards() == 2;
    }

    public boolean isBust(){
        return getValue() > 21;
    }

    public void clear(){
        hand = new Card[0];
    }
}
