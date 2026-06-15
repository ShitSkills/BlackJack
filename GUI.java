import javax.swing.*;

import javafx.scene.image.Image;

public class GUI {
public static void main(String[ ] args)
{
JFrame frame = new JFrame("BlackJack");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label = new JLabel(" Benutzeroberfläche für BlackJack");
frame.add(label);
frame.pack();

frame.setLocationRelativeTo(null);

frame.setVisible(true);
frame.setSize(800, 600);
}

}