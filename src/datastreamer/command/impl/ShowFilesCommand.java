package datastreamer.command.impl;

import java.util.List;

import datastreamer.command.Command;
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
	public boolean execute(List<String> args) {
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
