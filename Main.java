public class Main
{
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
}