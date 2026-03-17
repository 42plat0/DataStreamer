package datastreamer.main;

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
			context = Context.getInstance();
			commander = new Commander(terminal, fileManager, context);
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
