
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jaco.mp3.player.MP3Player;

/**
 * 
 * PlayerMethod class that set required action(s) for all 4 methods
 * open, play, pause and stop
 * This class inherit from the interface
 * Required attributes.
 *
 */
public class PlayerMethods implements PlayerInterface{
	private String mp3File="";
	File file = new File (mp3File);
	MP3Player mplayer = new MP3Player(file);
	
	/**
	 * 
	 * @return Mp3File which is the song
	 * playing and is in String.
	 */
	public String getMp3File() {
		return mp3File;
	}
	
	/**
	 * 
	 * @param mp3File which sets the song
	 * to be used and shown in label.
	 */
	public void setMp3File(String mp3File) {
		this.mp3File = mp3File;
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
	 * and select the mp3file. It also uses FileNameExtensionFilter to 
	 * filter showing files to only mp3 files. It also sets the 
	 * name of the file to mp3File to be shown in GUI label 
	 * and plays the selected file.
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
			setMp3File(file.getName());
			mplayer.play();
		}else{
			if (mplayer.isStopped()){ //if no song is playing and file not chosen
									//displays the massage. 
				setMp3File("<<Please load a mp3 file>>");
			}
		}
	}	
}
