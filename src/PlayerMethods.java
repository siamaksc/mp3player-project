/**
 * PlayerMethod class that set required action(s) for all 4 methods
 * open, play, pause and stop
 */
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jaco.mp3.player.MP3Player;

/**
 * 
 * This class inherit from the interface
 * Required attributes.
 *
 */
public class PlayerMethods implements PlayerInterface{
	private MP3Player mp3player;
	private String mp3File= "";
	private String songName = "";
	File file = new File (mp3File);
	MP3Player mplayer = new MP3Player(file);
	
	/**
	 * 
	 * @return Mp3layer
	 */
	public MP3Player getMp3player() {
		return mp3player;
	}
	
	/**
	 * 
	 * @param mp3player
	 */
	public void setMp3player(MP3Player mp3player) {
		this.mp3player = mp3player;
	}
	
	/**
	 * 
	 * @return SongName which is the name of the 
	 * song playing and in String.
	 */
	public String getSongName() {
		return songName;
	}
	
	/**
	 * 
	 * @param songName which sets the name of the song
	 * to be used and shown in label.
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	/**
	 * method plays which plays the song
	 */
	public void plays() {
		mplayer.play();
	}
	
	/**
	 * method pauses which pauses the song
	 */
	public void pauses() {
		mplayer.pause();
	}
	
	/**
	 * method stops which stops the song
	 */
	public void stops() {
		mplayer.stop();
	}
	
	/**
	 * method opens which uses JFileChooser to show the openDialog
	 * and select the mp3file.
	 * it also uses FileNameExtensionFilter to filter showing files
	 * to only mp3 files. It also sets the name of the file to
	 * songName to be shown in GUI label and plays the selected file.
	 */
	public void opens() {
		final JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 FILES", "mp3");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null); //this will open the dialog for opening files
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			mplayer.stop();
			mplayer = new MP3Player (file);
			String songName = file.getName();
			setSongName(songName);
			mplayer.play();
		}
	}	
}
