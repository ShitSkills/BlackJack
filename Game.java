public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;

    public Game() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void start() {
        deck.shuffle();
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        System.out.println(player);
        System.out.println(dealer);
    }
}
