package Client;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class KeyListen implements KeyListener {

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// FRECCIA SU
			Client.setJtext("UP");
			if (Client.dirUP.getDir() != true) {
				Client.dirUP.setDir(true);

				try {
					sendUDP(Client.dirUP);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// FRECCIA GIU
			Client.setJtext("DOWN");
			if (Client.dirDOWN.getDir() != true) {
				Client.dirDOWN.setDir(true);

				try {
					sendUDP(Client.dirDOWN);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// FRECCIA SINISTRA
			Client.setJtext("LEFT");
			if (Client.dirLEFT.getDir() != true) {
				Client.dirLEFT.setDir(true);

				try {
					sendUDP(Client.dirLEFT);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// FRECCIA DESTRA
			Client.setJtext("RIGHT");
			if (Client.dirRIGHT.getDir() != true) {
				Client.dirRIGHT.setDir(true);

				try {
					sendUDP(Client.dirRIGHT);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (Client.dirUP.getDir() == true) {
			Client.btnUP.setBackground(Color.GREEN);
		}
		if (Client.dirDOWN.getDir() == true) {
			Client.btnDOWN.setBackground(Color.GREEN);
		}
		if (Client.dirLEFT.getDir() == true) {
			Client.btnLEFT.setBackground(Color.GREEN);
		}
		if (Client.dirRIGHT.getDir() == true) {
			Client.btnRIGHT.setBackground(Color.GREEN);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// FRECCIA SU
			Client.setJtext("UP");
			if (Client.dirUP.getDir() != false) {
				Client.dirUP.setDir(false);
			}
			try {
				sendUDP(Client.dirUP);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// FRECCIA GIU
			Client.setJtext("DOWN");
			if (Client.dirDOWN.getDir() != false) {
				Client.dirDOWN.setDir(false);
			}

			try {
				sendUDP(Client.dirDOWN);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// FRECCIA SINISTRA
			Client.setJtext("LEFT");
			if (Client.dirLEFT.getDir() != false) {
				Client.dirLEFT.setDir(false);
			}

			try {
				sendUDP(Client.dirLEFT);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// FRECCIA DESTRA
			Client.setJtext("RIGHT");
			if (Client.dirRIGHT.getDir() != false) {
				Client.dirRIGHT.setDir(false);
			}

			try {
				sendUDP(Client.dirRIGHT);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (Client.dirUP.getDir() == false) {
			Client.btnUP.setBackground(null);
		}
		if (Client.dirDOWN.getDir() == false) {
			Client.btnDOWN.setBackground(null);
		}
		if (Client.dirLEFT.getDir() == false) {
			Client.btnLEFT.setBackground(null);
		}
		if (Client.dirRIGHT.getDir() == false) {
			Client.btnRIGHT.setBackground(null);
		}
	}

	private static InetAddress addr;
	private static byte[] msg = { 0 };

	public static void sendUDP(DirectionC dir) throws UnknownHostException, IOException {
		addr = InetAddress.getByName(Client.jtextIP.getText());

		msg = dir.toString().getBytes();

		// Creazione della Socket per l'invio del Datagramma con porta Client dinamica
		DatagramSocket s = new DatagramSocket();

		// Creazione del pacchetto da inviare al Server
		DatagramPacket hi = new DatagramPacket(msg, msg.length, addr, 7777);
		hi.setData(msg);
		hi.setLength(msg.length);

		// Invio
		s.send(hi);
	}

	public void keyTyped(KeyEvent e) {
	}

}
