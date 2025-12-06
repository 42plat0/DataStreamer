package datastreamer.main;

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
//			final File folder = new File();
//			Uploader uploader = new Uploader(folder);
//			TerminalBuilder terminalBuilder = TerminalBuilder.builder();
//			LineReaderBuilder lineReader = LineReaderBuilder.builder();
//			// Create a terminal
//			Terminal terminal = terminalBuilder.system(true).build();
//			// Create line reader
//			LineReader reader = lineReader.terminal(terminal).build();
//
//			while (true) {
//				// Prompt and read input
//				String line = reader.readLine("> ");
//
//				// Exit if requested
//				if ("exit".equalsIgnoreCase(line)) {
//					break;
//				}
//				if ("where".equalsIgnoreCase(line)) {
//					System.out.println(System.getProperty("user.dir"));
//				}
//
//				// Echo the line back to the user
//				terminal.writer().println("You entered: " + line);
//				terminal.flush();
//			}
//
//			System.out.println("Goodbye");
//			terminal.writer().println("Goodbye!");
//			terminal.close();
			terminal.start(commander);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File getDataFolder() throws URISyntaxException {
		return new File(DataStreamerApp.class.getResource("/resources/data/").toURI());
	}

}
