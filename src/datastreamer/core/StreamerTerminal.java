package datastreamer.core;

import java.util.List;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import datastreamer.data.Data;
import lombok.Getter;
import lombok.Setter;

/* _
 * 
 * Handles execution loop, sort of a window. Has program name and a prompt. 
 * 
 */

@Getter
@Setter
public class StreamerTerminal {

	private String programName;
	private String prompt;
	private Terminal terminal;
	private LineReader reader;
	private Cache cache;

	public StreamerTerminal(String programName, String promptSymbol) {
		this.programName = programName;
		this.prompt = programName + " " + promptSymbol;
	}

	/*
	 * Main execution loop. Commander executes as a seperate layer from execution
	 * loop.
	 */
	public void start(Commander commander) throws Exception {
		// Create a terminal
		terminal = TerminalBuilder.builder().system(true).build();
		// Create line reader
		reader = LineReaderBuilder.builder().terminal(terminal).build();
		// Instantiate a cache
		cache = Cache.getInstance();
		while (true) {
			String line = reader.readLine(prompt);
			boolean shouldExit = commander.execute(line);

			if (shouldExit) {
				break;
			}
		}

		System.out.println("Goodbye!"); // terminal.println not showing up
		terminal.close();
	}

	public void cacheData(List<Data> commandResultData) {
		cache.addData(commandResultData);

	}

	/*
	 * Handle printing a message, like a label, in commander;
	 * 
	 * Could be used as a part of an execption handling. Just an idea and no time to
	 * implement.
	 * 
	 * Seems like this doesn't work. We use system.out in start()
	 * 
	 */
	public void println(String line) {
		terminal.writer().println(line);
		terminal.flush();
	}

}
