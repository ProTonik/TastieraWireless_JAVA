package Server;

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
						System.err.println("dirUP");
						break;
					}
				}
			}
		};

		// executes the swingworker on worker thread
		sw1.execute();
	}
}
