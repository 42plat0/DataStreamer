package datastreamer.core;

import java.util.HashMap;
import java.util.Map;

import datastreamer.command.Command;
import datastreamer.command.ExitCommand;
import datastreamer.command.FileLoaderCommand;
import datastreamer.command.FunctionCommand;
import datastreamer.command.ShowFilesCommand;

// TODO execute file input into mmemory
public class Commander {
	public final static String LOAD_FILE = "lf";

	private final StreamerTerminal terminal;
	private FileManager fileManager;
	private final Map<String, Command> commands;

	public Commander(StreamerTerminal terminal, FileManager fileManager) {
		this.terminal = terminal;
		this.fileManager = fileManager;
		this.commands = new HashMap<String, Command>();
		registerCommands();
	}

	private void registerCommands() {
		commands.put(":q", new ExitCommand());
		commands.put("sf", new ShowFilesCommand(terminal, fileManager));
		commands.put("f", new FunctionCommand());
		commands.put(LOAD_FILE, new FileLoaderCommand(terminal, fileManager));
	}

	public boolean execute(String input) {
		CommandParser commandParser = new CommandParser(input);
		commandParser.parse(); // Important to have tho in design sucks

		Command command = commands.get(commandParser.getCommandKey());

		if (command == null) {
			terminal.println("Komanda nerasta");
			return false;
		}

		String[] restArgs = commandParser.getRestArgs();

		if (restArgs.length > 0) {
			return command.execute(commandParser.getRestArgs());
		}

		return command.execute();
	}
//	public final static String SHOW_FILES = "sf";
//	public final static String END = ":q";
//
//	// Filtravimas pagal duomenu stulpelius
//	public final static String FUNC_FILTER = "f";
//
//	// Duomuo diapozone (eg. data, skaicius, character);
//	public final static String RANGE = "r";
//
//	// Filtravimas duomens diapozone
//	public final static String FILTER_RANGE = FUNC_FILTER + RANGE;
//
//	// Perrikiavimo kryptis
//	public final static String ORD_ASC = "asc";
//	public final static String ORD_DESC = "desc";

}
