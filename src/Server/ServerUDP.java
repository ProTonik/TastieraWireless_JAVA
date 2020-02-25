package Server;

import java.awt.Color;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.SwingWorker;

public class ServerUDP extends Thread {

	public static void startThread(DatagramSocket s) throws SocketException {

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
							Server.btnUP.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							Server.btnUP.setBackground(null);
						}
						break;
					case "dirDOWN":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnDOWN.getBackground()) {
							Server.btnDOWN.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							Server.btnDOWN.setBackground(null);
						}
						break;
					case "dirLEFT":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnLEFT.getBackground()) {
							Server.btnLEFT.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
							Server.btnLEFT.setBackground(null);
						}
						break;
					case "dirRIGHT":
						if (Boolean.parseBoolean(parts[1]) == true && Color.GREEN != Server.btnRIGHT.getBackground()) {
							Server.btnRIGHT.setBackground(Color.GREEN);
						} else if (Boolean.parseBoolean(parts[1]) == false) {
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
