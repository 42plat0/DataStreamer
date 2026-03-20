package datastreamer.main;

/*_
 * 
 * Streamer app with multiple functionality or app parts. Now it's made of terminal for input design and running functionality. File manager is responsible for handling file system. Commander it seems purely is input control and handling functions.
 * 
 * */
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import datastreamer.core.Commander;
import datastreamer.core.Context;
import datastreamer.core.FileManager;
import datastreamer.core.StreamerTerminal;

public class DataStreamerApp {

	private StreamerTerminal terminal;
//	private CommandExecutor executor;
	private FileManager fileManager;
	private Commander commander;
	private Context context;

	public void run() {
		try {
			terminal = new StreamerTerminal("DataStreamer", "%");
			fileManager = new FileManager(getDataFolder());
<<<<<<< HEAD
			context = Context.getInstance();
			commander = new Commander(terminal, fileManager, context);
=======
			commander = new Commander(terminal, fileManager);
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git
			terminal.start(commander);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
			System.out.println("string could not be parsed as a URI reference");
		}
	}

	private File getDataFolder() throws URISyntaxException {
		return new File(DataStreamerApp.class.getResource("/resources/data/").toURI());
	}

}
