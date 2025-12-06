package datastreamer.command;

import datastreamer.core.FileManager;
import datastreamer.core.StreamerTerminal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShowFilesCommand implements Command {

	private StreamerTerminal terminal;
	private FileManager fileManager;

	@Override
	public boolean execute() {
		for (String fileName : fileManager.listFiles()) {
			terminal.println(fileName);
		}

		return false;
	}

	@Override
	public String getDescription() {
		return "Parodyti failu vardus";
	}

}
