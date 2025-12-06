package datastreamer.core;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamerTerminal {

	private String programName;
	private String prompt;
	private Terminal terminal;
	private LineReader reader;

	public StreamerTerminal(String programName, String promptSymbol) {
		this.programName = programName;
		this.prompt = programName + " " + promptSymbol;
	}

	public void start(Commander commander) throws Exception {
		// Create a terminal
		terminal = TerminalBuilder.builder().system(true).build();
		// Create line reader
		reader = LineReaderBuilder.builder().terminal(terminal).build();
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

	public void println(String line) {
		terminal.writer().println(line);
		terminal.flush();
	}

}
