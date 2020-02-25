package Server;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.*;

public class Server {
	private int port = 7777;
	InetAddress addr;
	DatagramSocket s = new DatagramSocket(port, addr);

	private JFrame frmServer;

	protected static JButton btnUP, btnDOWN, btnLEFT, btnRIGHT;
	private JTextField jtextIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frmServer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws AWTException
	 */
	public Server() throws UnknownHostException, IOException, AWTException {
		initialize();

		ServerUDP t = new ServerUDP();
		t.startThread(s);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws UnknownHostException
	 */
	private void initialize() throws UnknownHostException {
		frmServer = new JFrame();
		frmServer.setTitle("SERVER");
		frmServer.setBounds(100, 100, 450, 300);
		frmServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServer.getContentPane().setLayout(null);

		btnUP = new JButton("UP");
		btnUP.setBounds(158, 85, 89, 23);
		frmServer.getContentPane().add(btnUP);

		btnDOWN = new JButton("DOWN");
		btnDOWN.setBounds(158, 130, 89, 23);
		frmServer.getContentPane().add(btnDOWN);

		btnRIGHT = new JButton("RIGHT");
		btnRIGHT.setBounds(257, 108, 89, 23);
		frmServer.getContentPane().add(btnRIGHT);

		btnLEFT = new JButton("LEFT");
		btnLEFT.setBounds(59, 108, 89, 23);
		frmServer.getContentPane().add(btnLEFT);

		jtextIP = new JTextField();
		jtextIP.setText("192.168.1.255");
		addr = InetAddress.getByName(jtextIP.getText());
		jtextIP.setBounds(338, 11, 86, 20);
		frmServer.getContentPane().add(jtextIP);
		jtextIP.setColumns(10);
	}
}
