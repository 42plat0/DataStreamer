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
		String[] files = fileManager.listFiles();
		for (int i = 0; i < files.length; i++) {
			terminal.println(i + 1 + ". " + files[i]);
		}

		return false;
	}

	@Override
	public String getDescription() {
		return "Parodyti failu vardus";
	}

	@Override
	public boolean execute(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
