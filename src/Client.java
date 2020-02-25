import java.awt.EventQueue;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Client {

	// DIREZIONI
	protected static Direction dirUP = new Direction("dirUP", false), dirDOWN = new Direction("dirDOWN", false),
			dirLEFT = new Direction("dirLEFT", false), dirRIGHT = new Direction("dirRIGHT", false);

	private JFrame frame;
	private static JTextField jtext;

	public static void setJtext(String testo) {
		jtext.setText(testo);
	}

	protected static JButton btnUP, btnDOWN, btnLEFT, btnRIGHT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jtext = new JTextField();
		jtext.setEditable(false);
		jtext.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(jtext);
		jtext.setColumns(10);

		btnUP = new JButton("UP");
		btnUP.setBounds(158, 85, 89, 23);
		frame.getContentPane().add(btnUP);

		btnDOWN = new JButton("DOWN");
		btnDOWN.setBounds(158, 130, 89, 23);
		frame.getContentPane().add(btnDOWN);

		btnRIGHT = new JButton("RIGHT");
		btnRIGHT.setBounds(257, 108, 89, 23);
		frame.getContentPane().add(btnRIGHT);

		btnLEFT = new JButton("LEFT");
		btnLEFT.setBounds(59, 108, 89, 23);
		frame.getContentPane().add(btnLEFT);
	}
}
