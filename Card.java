public class Card
{
    private String suit;        // P , H, 
    private String rank;        // 2 - 10 B, Q, K, A
    private boolean faceDown;   // Für verdeckte Dealer-Karten

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.faceDown = false;
    }

    public int getValue()
    {
        if (rank.equals("A")) 
            {
                return 11;
            }
        if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) 
            {
                return 10;
            }
        try {
            int numRank = Integer.parseInt(rank);
            if (numRank >= 2 && numRank <= 10)
                {
                    return numRank;
                }
        } catch (NumberFormatException e) {
            // Ungültiger Rang
        }
        return 0;
    }

    public String getRank()
    {
        return rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public boolean isFaceDown()
    {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown)
    {
        this.faceDown = faceDown;
    }

    public String toString()
    {
        if (faceDown)
        {
            return "[Verdeckt]";
        }
        return rank + suit;
    }
}