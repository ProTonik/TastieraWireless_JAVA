package Client;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Client {

	// DIREZIONI
	protected static DirectionC dirUP = new DirectionC("dirUP", false), dirDOWN = new DirectionC("dirDOWN", false),
			dirLEFT = new DirectionC("dirLEFT", false), dirRIGHT = new DirectionC("dirRIGHT", false);

	private JFrame frmClient;
	private static JTextField jtext;

	public static void setJtext(String testo) {
		jtext.setText(testo);
	}

	protected static JButton btnUP, btnDOWN, btnLEFT, btnRIGHT;
	protected static JTextField jtextIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frmClient.setVisible(true);
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
	 */
	public Client() throws UnknownHostException, IOException {
		initialize();
		jtext.addKeyListener(new KeyListen());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("CLIENT");
		frmClient.setBounds(100, 100, 450, 300);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);

		jtext = new JTextField();
		jtext.setEditable(false);
		jtext.setBounds(10, 11, 86, 20);
		frmClient.getContentPane().add(jtext);
		jtext.setColumns(10);

		btnUP = new JButton("UP");
		btnUP.setBounds(158, 85, 89, 23);
		frmClient.getContentPane().add(btnUP);

		btnDOWN = new JButton("DOWN");
		btnDOWN.setBounds(158, 130, 89, 23);
		frmClient.getContentPane().add(btnDOWN);

		btnRIGHT = new JButton("RIGHT");
		btnRIGHT.setBounds(257, 108, 89, 23);
		frmClient.getContentPane().add(btnRIGHT);

		btnLEFT = new JButton("LEFT");
		btnLEFT.setBounds(59, 108, 89, 23);
		frmClient.getContentPane().add(btnLEFT);
		
		jtextIP = new JTextField();
		jtextIP.setText("192.168.1.10");
		jtextIP.setBounds(338, 11, 86, 20);
		frmClient.getContentPane().add(jtextIP);
		jtextIP.setColumns(10);
	}
}
