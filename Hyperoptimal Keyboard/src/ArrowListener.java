import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.keyboard.move("left");
			Main.namefield.move("left");
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.keyboard.move("right");
			Main.namefield.move("right");
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.keyboard.move("up");
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.keyboard.move("down");
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			char letter = Main.keyboard.select();
			Main.namefield.enter(letter);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
