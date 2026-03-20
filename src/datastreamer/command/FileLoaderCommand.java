package datastreamer.command;

import datastreamer.core.FileManager;
import datastreamer.core.StreamerTerminal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileLoaderCommand implements Command {

	private StreamerTerminal terminal;
	private FileManager fileManager;

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String[] args) {

		String[] allFiles = fileManager.listFiles();
		String[] filesToLoad = args;

		terminal.println("Files that will be loaded: ");
		for (String fileName : filesToLoad) {
			terminal.println(fileName);
		}

		terminal.cacheData(fileManager.getFilesInFormat(filesToLoad));

		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
