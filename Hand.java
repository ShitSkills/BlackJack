public class Hand{
    
    private Card[] hand;

    public Hand(Card[] hand){
        this.hand = hand;
        
    }

    public void addCard(Card card){

    }

    public int getValue(){
        int wert = 0;
        for(int i=0; i<hand.length; i++){
            wert += hand[i].getValue();
        }
        return wert;
    }

    public void hasBlackJack(){
        if(getValue() == 21){
            System.out.println("Gewonnen");
        }
    }

    public void isBust(){
        if(getValue() > 21){
            System.out.println("Verloren");
        }
    }
}
