import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Field extends JLabel {
	
	char letter;
	
	public Field() {
		this.letter = ' ';
		this.setText(" ");
		this.setFont(new Font("what", Font.PLAIN, 22));
		this.setBorder(NameField.underline);
		this.setPreferredSize(new Dimension(30, 40));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setBackground(new Color(248, 255, 180));
		this.setOpaque(true);
		JPanel container = new JPanel();
		container.setBackground(new Color(248, 255, 180));
		container.add(this);
		Main.namefield.add(container);
	}

}
