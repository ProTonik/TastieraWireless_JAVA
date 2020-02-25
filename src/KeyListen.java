import java.awt.Color;
import java.awt.event.*;

public class KeyListen implements KeyListener {

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// FRECCIA SU
			Client.setJtext("UP");
			if (Client.dirUP != true) {
				Client.dirUP = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// FRECCIA GIU
			Client.setJtext("DOWN");
			if (Client.dirDOWN != true) {
				Client.dirDOWN = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// FRECCIA SINISTRA
			Client.setJtext("LEFT");
			if (Client.dirLEFT != true) {
				Client.dirLEFT = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// FRECCIA DESTRA
			Client.setJtext("RIGHT");
			if (Client.dirRIGHT != true) {
				Client.dirRIGHT = true;
			}
		}

		if (Client.dirUP == true) {
			Client.btnUP.setBackground(Color.GREEN);
		}
		if (Client.dirDOWN == true) {
			Client.btnDOWN.setBackground(Color.GREEN);
		}
		if (Client.dirLEFT == true) {
			Client.btnLEFT.setBackground(Color.GREEN);
		}
		if (Client.dirRIGHT == true) {
			Client.btnRIGHT.setBackground(Color.GREEN);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// FRECCIA SU
			Client.setJtext("UP");
			if (Client.dirUP != false) {
				Client.dirUP = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// FRECCIA GIU
			Client.setJtext("DOWN");
			if (Client.dirDOWN != false) {
				Client.dirDOWN = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// FRECCIA SINISTRA
			Client.setJtext("LEFT");
			if (Client.dirLEFT != false) {
				Client.dirLEFT = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// FRECCIA DESTRA
			Client.setJtext("RIGHT");
			if (Client.dirRIGHT != false) {
				Client.dirRIGHT = false;
			}
		}

		if (Client.dirUP == false) {
			Client.btnUP.setBackground(null);
		}
		if (Client.dirDOWN == false) {
			Client.btnDOWN.setBackground(null);
		}
		if (Client.dirLEFT == false) {
			Client.btnLEFT.setBackground(null);
		}
		if (Client.dirRIGHT == false) {
			Client.btnRIGHT.setBackground(null);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
