import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewClass implements ActionListener{

	private JFrame frmSiaPlayer;
	JButton btnEject = new JButton("");
	JButton btnPlay = new JButton("");
	JButton btnPause = new JButton("");
	JButton btnStop = new JButton("");
	JLabel lblNewLabel = new JLabel("Please load a mp3 file");
	private PlayerMethods pm = new PlayerMethods();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					ViewClass window = new ViewClass();
					window.frmSiaPlayer.setVisible(true);
	}
	
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the application.
	 */
	public ViewClass() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frmSiaPlayer = new JFrame();
		frmSiaPlayer.getContentPane().setBackground(Color.GRAY);
		frmSiaPlayer.setBackground(Color.WHITE);
		frmSiaPlayer.setTitle("Sia MP3 Player");
		frmSiaPlayer.setBounds(100, 100, 357, 198);
		frmSiaPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSiaPlayer.getContentPane().setLayout(null);
		
		btnEject.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		btnEject.setBounds(44, 114, 55, 23);
		
		btnPlay.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		btnPlay.setBounds(109, 114, 55, 23);
		
		btnPause.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		btnPause.setBounds(174, 114, 55, 23);
		
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(44, 32, 250, 23);
		
		btnStop.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		btnStop.setBounds(239, 114, 55, 23);
		
	}
	public void addComponentsToFrame (){
		frmSiaPlayer.getContentPane().add(btnEject);
		frmSiaPlayer.getContentPane().add(btnPlay);
		frmSiaPlayer.getContentPane().add(btnPause);
		frmSiaPlayer.getContentPane().add(lblNewLabel);
		frmSiaPlayer.getContentPane().add(btnStop);
	}
	
	public void addActionListeners(){
		btnEject.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == btnEject) {
			pm.opens();
			//lblNewLabel.setText(file.getName());
			}
		
		
		if (e.getSource() == btnPlay){
			pm.plays();
			//System.out.println("Hi");
		}
		
		if (e.getSource() == btnStop){
			pm.stops();
		}
		
		if (e.getSource() == btnPause){
			pm.pauses();
		}
		
	
		
	}
	
}
