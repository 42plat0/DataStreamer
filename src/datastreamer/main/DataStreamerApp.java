package datastreamer.main;

/*_
 * 
 * Streamer app with multiple functionality or app parts. Now it's made of terminal for input design and running functionality. File manager is responsible for handling file system. Commander it seems purely is input control and handling functions.
 * 
 * */
import java.io.File;
import java.net.URISyntaxException;

import datastreamer.core.Commander;
import datastreamer.core.FileManager;
import datastreamer.core.StreamerTerminal;

public class DataStreamerApp {

	private StreamerTerminal terminal;
//	private CommandExecutor executor;
	private FileManager fileManager;
	private Commander commander;

	public void run() {
		try {
			terminal = new StreamerTerminal("DataStreamer", "%");
			fileManager = new FileManager(getDataFolder());
			commander = new Commander(terminal, fileManager);
			terminal.start(commander);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File getDataFolder() throws URISyntaxException {
		return new File(DataStreamerApp.class.getResource("/resources/data/").toURI());
	}

}
