

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardExample extends JPanel {
	public int y = 0;
	public int x = 0;
	public Boolean moved = false;
	public KeyboardExample() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}

	/*
	public static void main(String[] args) {
		//JFrame frame = new JFrame("Mini Tennis");
		KeyboardExample keyboardExample = new KeyboardExample();
		frame.add(keyboardExample);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	*/

	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			moved = true;
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				x-=10;
				moved = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				x+=10;
				moved = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_UP){
				y+=10;
				moved = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				y-=10;
				moved = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}

	}
}
