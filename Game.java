//package gui1;
import javax.swing.SwingUtilities;

public class Game {
    
    private GUI g; // ← Hier oben nur deklarieren
    
    public Game() {
        g = new GUI(this); // ← Hier im Konstruktor erzeugen
        g.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					Game game = new Game();
				} catch (Exception e) {
					e.printStackTrace(); 
				}
            }
        });
    }
    
    public void hit() {
        System.out.println("Hit gedrückt");
    }
    public void stand(){}
    public void Double(){}
    public void split(){}
}
