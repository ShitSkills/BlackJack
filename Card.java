public class Card {

    private String rank; // 2 - 10 B, Q, K, A
    private String suit; // P , H,
    private boolean faceDown; // Ist die Karte verdeckt?

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.faceDown = false; // Standardmäßig offen
    }

    public int getValue() {
        String r = rank == null ? "" : rank.trim().toLowerCase();
        if (r.equals("ass")) {
            return 11;
        }
        if (r.equals("könig") || r.equals("dame") || r.equals("bube")) {
            return 10;
        }
        try {
            int numRank = Integer.parseInt(r);
            if (numRank >= 2 && numRank <= 10) {
                return numRank;
            }
        } catch (NumberFormatException e) {
            // Ungültiger Rang
        }
        return 0;
    }

    public boolean isAce() {
        String r = rank == null ? "" : rank.trim().toLowerCase();
        return r.equals("ass") || r.equals("a") || r.equals("ace");
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }

    public void flipCard() {
        this.faceDown = !this.faceDown;
    }

    public String getDisplayValue() {
        if (faceDown) {
            return "XX"; // Verdeckte Karte anzeigen
        }
        return toString();
    }

    public String toString() {
        return suit + rank;
    }
}