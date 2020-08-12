import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {
	
	static MyFrame frame;
	static Keyboard keyboard;
	static NameField namefield;
	static JLabel text;
	static boolean passwordmode = false;
	static String username;

	public static void main(String[] args) {
		frame = new MyFrame("Typeddit");
		keyboard = frame.keyboard;
		namefield = frame.namefield;
		namefield.init();
		keyboard.init();
		addText();
		frame.setVisible(true);
	}

	private static void addText() {
		JLabel text = new JLabel("Please choose a username.");
		text.setBackground(Color.WHITE);
		text.setPreferredSize(new Dimension(540, 50));
		text.setOpaque(true);
		text.setFont(new Font("what", Font.PLAIN, 22));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setPreferredSize(new Dimension(540, 50));
		container.add(text);
		frame.add(container, BorderLayout.NORTH);
		Main.text = text;
	}
	
	public static void setPasswordMode() {
		Main.username = "" + Main.namefield;
		passwordmode = true;
		namefield.setPasswordMode();
		Main.text.setText("Please choose a password.");
	}

	public static void success() {
		JDialog success = new JDialog(Main.frame, "Success!", false);
		success.setSize(380, 120);
		success.setLocationRelativeTo(null);
		String password = "" + Main.namefield;
		JLabel text = new JLabel(String.format("<html>Successfully registered as %s!<br>Password: %s</html>"
				, Main.username, password));
		text.setFont(new Font("what", Font.PLAIN, 18));
		JPanel container = new JPanel();
		container.add(text);
		success.add(container);
		success.setVisible(true);
	}

	
}
