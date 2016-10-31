import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	private MP3Player mp3player;
	//private String mp3File= "C:\\Users\\Sia\\Dropbox\\Nackademin\\W9\\Mandatory assignment\\03. Turning Tables.mp3";
	private String mp3File= "";
	File file = new File (mp3File);
	MP3Player mplayer = new MP3Player(file);
	
	public MP3Player getMp3player() {
		return mp3player;
	}

	public void setMp3player(MP3Player mp3player) {
		this.mp3player = mp3player;
	}
	
	@Override
	public void plays() {
		//if (mp3File != null){
		mplayer.play();
		//}else{
			//System.out.println("Please load a file first");
		//}
	}
	@Override
	public void pauses() {
		mplayer.pause();
	}
	@Override
	public void stops() {
		mplayer.stop();
		System.out.println("stop");
	}

	@Override
	public void opens() {
		final JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(null); //this will open the dialog for oppening files
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			//System.out.println(file.getAbsolutePath());
			//mplayer.stop();
			mplayer = new MP3Player (file);
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setText(file.getName());
			mplayer.play();
		}
	}	
}
