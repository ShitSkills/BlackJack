public class Card
{
    private String suit;        // P , H, 
    private String rank;        // 2 - 10 B, Q, K, A

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue()
    {
        if (rank == "A") 
            {
                return 11;
            }
        if (rank == "K" || rank == "Q" || rank == "J") 
            {
                return 10;
            }
        if (Integer.parseInt(rank) >= 2 && Integer.parseInt(rank) <= 10)
            {
                return Integer.parseInt(rank);
            }
        return 0;
    }
}