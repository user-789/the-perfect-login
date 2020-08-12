import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	Keyboard keyboard;
	NameField namefield;
	
	public MyFrame(String title) {
		super(title);
		namefield = new NameField();
		keyboard = new Keyboard();
		addKeyListener(new ArrowListener());
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(540, 360));
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
