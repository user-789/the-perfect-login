import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Key extends JLabel {
	
	char letter;
	
	public Key(String text) {
		super(text);
		letter = text.charAt(0);
		this.setFont(new Font("what", Font.PLAIN, 22));
		this.setPreferredSize(new Dimension(40, 40));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setBorder(Keyboard.border);
		this.setOpaque(true);
		this.setBackground(new Color(220, 220, 220));
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.add(this);
		Main.keyboard.add(container);
	}
	
	/*
	public Key(String text, char letter) {
		super(text);
		this.letter = letter;
		Main.keyboard.add(this);
	}*/

}
