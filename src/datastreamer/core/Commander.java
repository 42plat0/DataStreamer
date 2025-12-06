package datastreamer.core;

import java.util.HashMap;
import java.util.Map;

import datastreamer.command.Command;
import datastreamer.command.ExitCommand;
import datastreamer.command.FunctionCommand;
import datastreamer.command.ShowFilesCommand;

public class Commander {
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
	}

	public boolean execute(String input) {
		Command command = commands.get(input);

		if (command == null) {
			terminal.println("Komanda nerasta");
			return false;
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
