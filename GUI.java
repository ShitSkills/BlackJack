//package gui1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image backgroundImage;

	private JPanel dealerPanel;
	private JPanel playerPanel;
	private JPanel statusPanel;
	private JPanel buttonPanel;
	private JPanel playerCardsPanel;
	private JPanel dealerCardsPanel;
	private JLabel lblInfo;
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

	private final int cardW = 60;
	private final int cardH = 90;
	private final int offsetX = 15;
	private final int offsetY = 15;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * GUI frame = new GUI();
	 * frame.setVisible(true);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 * 
	 * 
	 * /**
	 * Create the frame.
	 */
	public GUI(Game game) {
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setResizable(false);
		backgroundImage = new ImageIcon("Bilder/Blackjack Spielfeld.jpg").getImage();
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					int width = getWidth();
					int height = getHeight();
					int imgW = backgroundImage.getWidth(null);
					int imgH = backgroundImage.getHeight(null);
					if (imgW > 0 && imgH > 0) {
						double scale = Math.max((double) width / imgW, (double) height / imgH);
						int w = (int) (imgW * scale);
						int h = (int) (imgH * scale);
						int x = (width - w) / 2;
						int y = (height - h) / 2;
						g.drawImage(backgroundImage, x, y, w, h, this);
					}
				}
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dealerPanel = new JPanel();
		dealerPanel.setBounds(10, 10, 960, 260);
		dealerPanel.setOpaque(false);
		contentPane.add(dealerPanel);
		dealerPanel.setLayout(null);

		lblDealer = new JLabel("Dealer");
		lblDealer.setBounds(400, 10, 90, 25);
		lblDealer.setFont(new Font("SansSerif", Font.BOLD, 18));
		dealerPanel.add(lblDealer);

		lblDealerWert = new JLabel("Wert: 0");
		lblDealerWert.setBounds(500, 10, 140, 25);
		lblDealerWert.setFont(new Font("SansSerif", Font.BOLD, 18));
		dealerPanel.add(lblDealerWert);

		dealerCardsPanel = new JPanel();
		dealerCardsPanel.setOpaque(false);
		dealerCardsPanel.setLayout(null);
		dealerCardsPanel.setBounds(10, 35, 940, 190);
		dealerPanel.add(dealerCardsPanel);

		playerPanel = new JPanel();
		playerPanel.setBounds(10, 280, 960, 260);
		playerPanel.setOpaque(false);
		contentPane.add(playerPanel);
		playerPanel.setLayout(null);

		lblPlayer = new JLabel("Spieler");
		lblPlayer.setBounds(400, 90, 90, 25);
		lblPlayer.setFont(new Font("SansSerif", Font.BOLD, 18));
		playerPanel.add(lblPlayer);

		lblSpielerWert = new JLabel("Wert: 0");
		lblSpielerWert.setBounds(500, 90, 140, 25);
		lblSpielerWert.setFont(new Font("SansSerif", Font.BOLD, 18));
		playerPanel.add(lblSpielerWert);

		playerCardsPanel = new JPanel();
		playerCardsPanel.setOpaque(false);
		playerCardsPanel.setLayout(null);
		playerCardsPanel.setBounds(10, 35, 940, 220);
		playerPanel.add(playerCardsPanel);

		statusPanel = new JPanel();
		statusPanel.setBounds(10, 550, 960, 40);
		statusPanel.setOpaque(false);
		contentPane.add(statusPanel);
		statusPanel.setLayout(null);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 600, 960, 60);
		buttonPanel.setOpaque(false);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);

		btnNeueRunde = new JButton("Neue Runde");
		btnNeueRunde.setBounds(220, 5, 110, 30);
		buttonPanel.add(btnNeueRunde);
		btnNeueRunde.addActionListener(e -> game.NeueRunde());

		btnDouble = new JButton("Double");
		btnDouble.setBounds(340, 5, 95, 30);
		buttonPanel.add(btnDouble);
		btnDouble.addActionListener(e -> game.Double());

		btnHit = new JButton("Hit");
		btnHit.setBounds(445, 5, 70, 30);
		buttonPanel.add(btnHit);
		btnHit.addActionListener(e -> game.hit());

		btnStand = new JButton("Stand");
		btnStand.setBounds(525, 5, 80, 30);
		buttonPanel.add(btnStand);
		btnStand.addActionListener(e -> game.stand());

		btnSplit = new JButton("Split");
		btnSplit.setBounds(615, 5, 80, 30);
		buttonPanel.add(btnSplit);
		btnSplit.addActionListener(e -> game.split());

		lblInfo = new JLabel("Willkommen zu Blackjack!");
		lblInfo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(400, 0, 500, 30);
		statusPanel.add(lblInfo);
		statusPanel.setComponentZOrder(lblInfo, 0);
	}

	private ImageIcon loadImage(String path, int w, int h) {
		File f = new File(path);
		if (!f.exists())
			return null;
		ImageIcon ico = new ImageIcon(f.getPath());
		Image img = ico.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}

	public void addCardToPlayer(Card card) {
		String base = "Bilder/" + card.toString() + ".jpg";
		ImageIcon icon = loadImage(base, cardW, cardH);
		JLabel label = (icon != null) ? new JLabel(icon) : new JLabel(card.toString());

		int index = playerCardsPanel.getComponentCount(); // Wie viele Karten sind schon drin?
		int x = 442 + index * offsetX; // Abstand zwischen den Karten
		int y = 120 - index * offsetY;

		label.setBounds(x, y, cardW, cardH);
		playerCardsPanel.add(label);
		playerCardsPanel.setComponentZOrder(label, 0);
		playerCardsPanel.revalidate();
		playerCardsPanel.repaint();
	}

	public void addCardToDealer(Card card) {
		ImageIcon icon;
		if (card.isFaceDown()) {
			icon = loadImage("Bilder/Kartenrücken.jpg", cardW, cardH);
		} else {
			String base = "Bilder/" + card.toString() + ".jpg";
			icon = loadImage(base, cardW, cardH);
		}
		JLabel label = (icon != null) ? new JLabel(icon) : new JLabel(card.isFaceDown() ? "??" : card.toString());

		int index = dealerCardsPanel.getComponentCount();
		int x = 410 + index * (cardW + 3);
		int y = 20;

		label.setBounds(x, y, cardW, cardH);

		dealerCardsPanel.add(label);
		dealerCardsPanel.setComponentZOrder(label, 0);
		dealerCardsPanel.revalidate();
		dealerCardsPanel.repaint();
	}

	public void refreshDealerCards(Hand hand) {
		dealerCardsPanel.removeAll();
		for (int i = 0; i < hand.getCardCount(); i++) {
			Card card = hand.getCard(i);
			addCardToDealer(card);
		}
		dealerCardsPanel.revalidate();
		dealerCardsPanel.repaint();
	}

	public void clearCards() {
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

	public void setInfoLabel(String text) {
		lblInfo.setText(text);
	}

	public void clearInfoLabel() {
		lblInfo.setText("");
	}

	public void disableGameButtons() {
		btnHit.setEnabled(false);
		btnStand.setEnabled(false);
		btnDouble.setEnabled(false);
		btnSplit.setEnabled(false);
		btnHit.setVisible(false);
		btnStand.setVisible(false);
		btnDouble.setVisible(false);
		btnSplit.setVisible(false);
	}

	public void enableGameButtons() {
		btnHit.setEnabled(true);
		btnStand.setEnabled(true);
		btnDouble.setEnabled(true);
		btnSplit.setEnabled(true);
		btnHit.setVisible(true);
		btnStand.setVisible(true);
		btnDouble.setVisible(true);
		btnSplit.setVisible(true);
	}

}