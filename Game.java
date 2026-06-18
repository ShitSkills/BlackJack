//package gui1;
import javax.swing.SwingUtilities;

public class Game
{
    private GUI g; // ← Hier oben nur deklarieren
    private Player player;
    private Dealer dealer;
    private Deck deck;

    
    public Game() {
        g = new GUI(this); // ← Hier im Konstruktor erzeugen
        g.setVisible(true);
        player = new Player("Player");
        dealer = new Dealer();
        deck = new Deck(6);
    }

    public void startGame() {
        deck.shuffle();
        player.resetHand();
        dealer.resetHand();

        // Spieler erhält 2 Karten
        Card pcarddeck.drawCard();
        Card cardp2= deck.drawCard();

        player.takeCard(card1);
        player.takeCard(card2);

        // Dealer erhält 2 Karten
        dealer.takeCard(deck.drawCard());
        dealer.takeCard(deck.drawCard());

        updateGUI();
    }

    public void NeueRunde()
    {
    
    }
    

    public void hit() {
    // 1. Karte ziehen
    Card card = deck.drawCard();

    // 2. Spieler bekommt die Karte
    player.takeCard(card);

    // 3. GUI aktualisieren
    g.addCardToPlayer(card.toString());
    lblSpielerWert.setText("Wert: " + player.getHandValue());

    // 4. Prüfen, ob der Spieler verloren hat oder Blackjack hat
    if (player.isBusted()) {
        // Runde beenden: Dealer gewinnt
        endRound("Bust! Dealer gewinnt.");
    } else if (player.hasBlackJack()) {
        // Runde beenden oder Dealer-Zug starten
        stand();
    }
    }
    
    public void stand()
    {

    }

    public void Double()
    {

    }

    public void split()
    {

    }
}
