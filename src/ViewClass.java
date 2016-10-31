
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * 
 * This class is the GUI part of the mp3 player program.
 * It has parts containing the whole GUI and actionPerformed 
 * when either of 4 buttons were clicked.
 * 
 */

public class ViewClass implements ActionListener{
	/**
	 * attributes
	 */
	private JFrame frmSiaPlayer;
	JButton btnEject = new JButton("");
	JButton btnPlay = new JButton("");
	JButton btnPause = new JButton("");
	JButton btnStop = new JButton("");
	JLabel lblNewLabel = new JLabel("<<Please load a mp3 file>>");
	private PlayerMethods pm = new PlayerMethods();
	
	/**
	 * @return frmSiaPlayer to be used in Main class
	 */
	public JFrame getFrmSiaPlayer() {
		return frmSiaPlayer;
	}
	
	/**
	 * 
	 * @param frmSiaPlayer 
	 */
	public void setFrmSiaPlayer(JFrame frmSiaPlayer) {
		this.frmSiaPlayer = frmSiaPlayer;
	}

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
		setFrmSiaPlayer(new JFrame());
		getFrmSiaPlayer().getContentPane().setBackground(Color.GRAY);
		getFrmSiaPlayer().setBackground(Color.WHITE);
		getFrmSiaPlayer().setTitle("Sia MP3 Player");
		getFrmSiaPlayer().setBounds(100, 100, 357, 198);
		getFrmSiaPlayer().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmSiaPlayer().getContentPane().setLayout(null);
		
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
	
	/**
	 * Adding all 4 buttons and one label to the frame
	 */
	public void addComponentsToFrame (){
		getFrmSiaPlayer().getContentPane().add(btnEject);
		getFrmSiaPlayer().getContentPane().add(btnPlay);
		getFrmSiaPlayer().getContentPane().add(btnPause);
		getFrmSiaPlayer().getContentPane().add(lblNewLabel);
		getFrmSiaPlayer().getContentPane().add(btnStop);
	}
	
	/**
	 * adding actionListeners
	 */
	public void addActionListeners(){
		btnEject.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
	}
	
	/**
	 * ActionPerformed for all 4 buttons
	 * when they were clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnEject) {
			pm.opens();
			lblNewLabel.setText(pm.getMp3File());
			}
		
		if (e.getSource() == btnPlay){
			pm.plays();
			lblNewLabel.setText(pm.getMp3File());
		}
		
		if (e.getSource() == btnStop){
			pm.stops();
		}
		
		if (e.getSource() == btnPause){
			pm.pauses();
		}
	}
}
