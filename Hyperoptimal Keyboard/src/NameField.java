import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class NameField extends JPanel {
	
	static Border underline = new MatteBorder(0, 0, 3, 0, Color.BLACK);
	static Border selectedline = new MatteBorder(0, 0, 5, 0, new Color(60, 90, 255));
	Field[] fields;
	final int SIZE = 13;
	int pos;
	
	NameField() {
		
	}
	
	public void move(String string) {
		if (string.equals("right")) {
			fields[pos].setBorder(underline);
			pos = (pos + 1) % SIZE;
			fields[pos].setBorder(selectedline);
		} else if (string.equals("left")) {
			fields[pos].setBorder(underline);
			pos = (pos - 1 + SIZE) % SIZE;
			fields[pos].setBorder(selectedline);
		}
	}

	public void enter(char letter) {
		if (letter == '?') {
			Main.keyboard.caps();
			return;
		}
		if (letter == '!') {
			if (!Main.passwordmode)
				Main.setPasswordMode();
			else
				Main.success();
			return;
		}
		
		Field field = fields[pos];
		field.letter = letter;
		if (!Main.passwordmode)
			field.setText(""+letter);
	}
	
	public void init() {
		this.setLayout(new GridLayout(1, SIZE));
		this.setPreferredSize(new Dimension(540, 60));
		this.setBackground(new Color(248, 255, 180));
		this.fields = new Field[SIZE];
		for (int i = 0; i < SIZE; i++) {
			this.fields[i] = new Field();
		}
		fields[0].setBorder(selectedline);
		Main.frame.add(this, BorderLayout.CENTER);
	}
	
	public void setPasswordMode() {
		for (Field field: fields) {
			field.letter = ' ';
			field.setText("*");
		}
	}
	
	@Override
	public String toString() {
		return Arrays.stream(fields).map((a) -> (""+a.letter)).reduce("", (a, b) -> (a+b)).trim();
	}

}
