
//package gui1;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class Game {
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
        NeueRunde();
    }

    public void NeueRunde() {
        g.clearCards();
        player.resetHand();
        dealer.resetHand();

        // Spieler erhält 2 Karten
        Card cardp1 = deck.drawCard();
        Card cardp2 = deck.drawCard();

        player.takeCard(cardp1);
        player.takeCard(cardp2);

        // Dealer erhält 2 Karten
        Card cardd1 = deck.drawCard();
        Card cardd2 = deck.drawCard();
        cardd1.setFaceDown(true);

        dealer.takeCard(cardd1);
        dealer.takeCard(cardd2);

        // GUI aktualisieren
        g.addCardToPlayer(cardp1);
        g.addCardToPlayer(cardp2);
        g.addCardToDealer(cardd1);
        g.addCardToDealer(cardd2);

        g.updatePlayerValue(player.getHandValue());
        g.updateDealerValue(dealer.getHandValue());
    }

    public void hit() {
        // 1. Karte ziehen
        Card card = deck.drawCard();

        // 2. Spieler bekommt die Karte
        player.takeCard(card);

        // 3. GUI aktualisieren
        g.addCardToPlayer(card);
        g.updatePlayerValue(player.getHandValue());
        g.updateDealerValue(dealer.getHandValue());

        // 4. Prüfen, ob der Spieler verloren hat oder Blackjack hat
        if (player.isBusted()) {
            // Runde beenden: Dealer gewinnt
            endRound("Bust! Dealer gewinnt.");
        } else if (player.hasBlackJack()) {
            // Runde beenden oder Dealer-Zug starten
            endRound("Blackjack! Spieler gewinnt.");
            stand();
        }
        
    }

    public void stand() {
        dealer.revealHand();
        g.refreshDealerCards(dealer.getHand());
        g.updateDealerValue(dealer.getHandValue()); // Dealers face down card wird gezeigt
        // Dealer zieht Karten, bis er mindestens 17 Punkte hat
        while (dealer.getHandValue() < 17) {
            Card card = deck.drawCard();
            dealer.takeCard(card);
            g.addCardToDealer(card);
            g.updateDealerValue(dealer.getHandValue());
        }

        // Ergebnis prüfen
        if (dealer.isBusted()) {
            endRound("Dealer Bust! Spieler gewinnt.");
        } else if (dealer.hasBlackJack()) {
            endRound("Dealer hat Blackjack! Dealer gewinnt.");
        } else {
            int playerValue = player.getHandValue();
            int dealerValue = dealer.getHandValue();

            if (playerValue > dealerValue) {
                endRound("Spieler gewinnt!");
            } else if (playerValue < dealerValue) {
                endRound("Dealer gewinnt!");
            } else {
                endRound("Unentschieden!");
            }
        }
    }

    public void Double() {

    }

    public void split() {

    }

    public void endRound(String message) {
        System.out.println(message);
        
    }
}
