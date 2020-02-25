package Server;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.SwingWorker;

public class ServerUDP extends Thread {

	private static Robot r;

	public static void startThread(DatagramSocket s) throws SocketException, AWTException {

		r = new Robot();

		SwingWorker sw1 = new SwingWorker() {

			@Override
			protected String doInBackground() throws Exception {
				// Informazioni sul Server in ascolto
				InetAddress indirizzo = s.getLocalAddress();
				String server = indirizzo.getHostAddress();
				int port = s.getLocalPort();
				System.out.println("In ascolto Server UDP: " + server + " porta: " + port);

				// Ciclo infinito per ascolto dei Client
				while (true) {
					// Preparazione delle informazioni da ricevere
					byte[] buf = new byte[65536];
					System.out.println("In attesa di chiamate dai Client... ");
					DatagramPacket recv = new DatagramPacket(buf, buf.length);
					s.receive(recv);

					// Messaggio ricevuto dal Client
					String messaggio = (new String(recv.getData()).trim());

					String parts[] = messaggio.split(",");

					switch (parts[0]) {
					case "dirUP":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnUP.getBackground()) {
							r.keyPress(KeyEvent.VK_UP);
							Server.btnUP.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							r.keyRelease(KeyEvent.VK_UP);
							Server.btnUP.setBackground(null);
						}
						break;
					case "dirDOWN":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnDOWN.getBackground()) {
							r.keyPress(KeyEvent.VK_DOWN);
							Server.btnDOWN.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							r.keyRelease(KeyEvent.VK_DOWN);
							Server.btnDOWN.setBackground(null);
						}
						break;
					case "dirLEFT":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnLEFT.getBackground()) {
							r.keyPress(KeyEvent.VK_LEFT);
							Server.btnLEFT.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							r.keyRelease(KeyEvent.VK_LEFT);
							Server.btnLEFT.setBackground(null);
						}
						break;
					case "dirRIGHT":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnRIGHT.getBackground()) {
							r.keyPress(KeyEvent.VK_RIGHT);
							Server.btnRIGHT.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							r.keyRelease(KeyEvent.VK_RIGHT);
							Server.btnRIGHT.setBackground(null);
						}
						break;
					}
				}
			}
		};

		// executes the swingworker on worker thread
		sw1.execute();
	}
}
