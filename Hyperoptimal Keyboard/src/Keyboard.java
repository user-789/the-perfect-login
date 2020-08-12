import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Keyboard extends JPanel {
	
	static Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	static Border selectedborder = BorderFactory.createLineBorder(new Color(60, 90, 255), 6);
	Key[][] keys;
	int y = 0;
	int x = 0;
	boolean capital;
	
	public Keyboard() {
		
	}

	public void move(String string) {
		if (string.equals("left")) {
			keys[y][x].setBorder(border);
			x = (x+9) % 10;
			keys[y][x].setBorder(selectedborder);
		} else if (string.equals("right")) {
			keys[y][x].setBorder(border);
			x = (x+1) % 10;
			keys[y][x].setBorder(selectedborder);
		} else if (string.equals("up")) {
			keys[y][x].setBorder(border);
			y = (y+3) % 4;
			keys[y][x].setBorder(selectedborder);
		} else if (string.equals("down")) {
			keys[y][x].setBorder(border);
			y = (y+1) % 4;
			keys[y][x].setBorder(selectedborder);
		}
		
	}

	public char select() {
		// TODO Auto-generated method stub
		if (y == 3 && x == 0) {
			return '?';
		}
		if (y == 3 && x == 9) {
			return '!';
		}
		return keys[y][x].letter;
	}
	
	public void init() {
		keys = new Key[4][10];
		capital = false;
		this.setLayout(new GridLayout(4, 10));
		this.setPreferredSize(new Dimension(540, 220));
		keys[0] = Arrays.copyOf(Arrays.stream(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}).map((s) -> (new Key(s))).toArray(), 10, Key[].class);
		keys[1] = Arrays.copyOf(Arrays.stream(new String[] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"}).map((s) -> (new Key(s))).toArray(), 10, Key[].class);
		keys[2] = Arrays.copyOf(Arrays.stream(new String[] {"a", "s", "d", "f", "g", "h", "j", "k", "l", "-"}).map((s) -> (new Key(s))).toArray(), 10, Key[].class);
		keys[3] = Arrays.copyOf(Arrays.stream(new String[] {"⇧", "z", "x", "c", "v", "b", "n", "m", " ", "✓"}).map((s) -> (new Key(s))).toArray(), 10, Key[].class);
		keys[0][0].setBorder(selectedborder);
		keys[3][0].setBackground(Color.LIGHT_GRAY);
		keys[3][9].setBackground(Color.GREEN);
		this.setBackground(Color.WHITE);
		
		Main.frame.add(this, BorderLayout.SOUTH);
	}
	
	public void caps() {
		capital = !capital;
		for (Key[] row: keys) {
			for (Key key: row) {
				if (Character.isLetter(key.letter)) {
					if (capital) {
						key.letter = Character.toUpperCase(key.letter);
					} else {
						key.letter = Character.toLowerCase(key.letter);
					}
					key.setText(""+key.letter);
				}
			}
		}
	}


}
