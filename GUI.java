//package gui1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel dealerPanel;
	private JPanel playerPanel;
	private JPanel statusPanel;
	private JPanel buttonPanel;
	private JPanel playerCardsPanel;
	private JPanel dealerCardsPanel;
	private JLabel lblSpielerWert;
	private JLabel lblDealerWert;
	private JLabel lblPlayer;
	private JLabel lblDealer;
	private JButton btnHit;
	private JButton btnStand;
	private JButton btnNeueRunde;
	private JButton btnDouble;
	private JButton btnSplit;
	private int playerCardCount = 0;
	private int dealerCardCount = 0;
	
	private Game game;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public GUI(Game game) {
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dealerPanel = new JPanel();
		dealerPanel.setBounds(10, 10, 960, 260);
		contentPane.add(dealerPanel);
		dealerPanel.setLayout(null);
		
		lblDealer = new JLabel("Dealer");
		lblDealer.setBounds(443, 5, 32, 14);
		dealerPanel.add(lblDealer);
		
		lblDealerWert = new JLabel("Wert: 0");
		lblDealerWert.setBounds(487, 5, 37, 14);
		dealerPanel.add(lblDealerWert);
		
		dealerCardsPanel = new JPanel();
		dealerCardsPanel.setBounds(10, 35, 940, 190);
		dealerPanel.add(dealerCardsPanel);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(10, 280, 960, 260);
		contentPane.add(playerPanel);
		playerPanel.setLayout(null);
		
		lblPlayer = new JLabel("Spieler");
		lblPlayer.setBounds(443, 5, 32, 14);
		playerPanel.add(lblPlayer);
		
		lblSpielerWert = new JLabel("Wert: 0");
		lblSpielerWert.setBounds(480, 5, 37, 14);
		playerPanel.add(lblSpielerWert);
		
		playerCardsPanel = new JPanel();
		playerCardsPanel.setBounds(10, 35, 940, 190);
		playerPanel.add(playerCardsPanel);
		
		statusPanel = new JPanel();
		statusPanel.setBounds(10, 550, 960, 40);
		contentPane.add(statusPanel);
		statusPanel.setLayout(null);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 600, 960, 60);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnNeueRunde = new JButton("Neue Runde");
		btnNeueRunde.setBounds(312, 5, 91, 23);
		buttonPanel.add(btnNeueRunde);
        //btnNeueRunde.addActionListener(e -> game.neueRunde());
		
		btnDouble = new JButton("Double");
		btnDouble.setBounds(408, 5, 65, 23);
		buttonPanel.add(btnDouble);
        btnDouble.addActionListener(e -> game.Double());
		
		btnHit = new JButton("Hit");
		btnHit.setBounds(478, 5, 45, 23);
		buttonPanel.add(btnHit);
		btnHit.addActionListener(e -> game.hit());
		
		btnStand = new JButton("Stand");
		btnStand.setBounds(528, 5, 61, 23);
		buttonPanel.add(btnStand);
        btnStand.addActionListener(e -> game.stand());

		btnSplit = new JButton("Split");
		btnSplit.setBounds(594, 5, 53, 23);
		buttonPanel.add(btnSplit);
        btnSplit.addActionListener(e -> game.split());

	}
	
	public void addCardToPlayer(String card) {
	    JLabel cardLabel = new JLabel(card.toString());
	    playerCardsPanel.add(cardLabel);
	    playerCardsPanel.revalidate();
	    playerCardsPanel.repaint();
	}

    public void addCardToDealer(String card) {
	    JLabel cardLabel = new JLabel(card.toString());
	    dealerCardsPanel.add(cardLabel);
	    dealerCardsPanel.revalidate();
	    dealerCardsPanel.repaint();
	}

    public void clearCards()
    {
        playerCardsPanel.removeAll();
        dealerCardsPanel.removeAll();
        playerCardsPanel.revalidate();
        playerCardsPanel.repaint();
        dealerCardsPanel.revalidate();
        dealerCardsPanel.repaint();
    }

    public void updatePlayerValue(int value) {
        lblSpielerWert.setText("Wert: " + value);
    }

    public void updateDealerValue(int value) {
        lblDealerWert.setText("Wert: " + value);
    }

}