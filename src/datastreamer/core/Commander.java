package datastreamer.core;

import java.util.HashMap;
import java.util.Map;

import datastreamer.command.Command;
import datastreamer.command.CommandList;
import datastreamer.command.CommandParser;
import datastreamer.command.impl.ExitCommand;
import datastreamer.command.impl.FunctionCommand;
import datastreamer.command.impl.LoadFilesCommand;
import datastreamer.command.impl.ShowCommandsCommand;
import datastreamer.command.impl.ShowDataCommand;
import datastreamer.command.impl.ShowFilesCommand;

public class Commander {
	private final StreamerTerminal terminal;
	private FileManager fileManager;
	private Context context;

	private final Map<String, Command> commands;

	public Commander(StreamerTerminal terminal, FileManager fileManager, Context context) {
		this.terminal = terminal;
		this.fileManager = fileManager;
		this.context = context;
		this.commands = new HashMap<String, Command>();
		registerCommands();
	}

	private void registerCommands() {
		commands.put(CommandList.EXIT_CMD, new ExitCommand());
		commands.put(CommandList.SHOW_FILES_CMD, new ShowFilesCommand(terminal, fileManager));
		commands.put(CommandList.FUNCTION_CMD, new FunctionCommand());
		commands.put(CommandList.SHOW_COMMANDS_CMD, new ShowCommandsCommand(terminal, commands));
		commands.put(CommandList.LOAD_FILES_CMD, new LoadFilesCommand(fileManager));
		commands.put(CommandList.SHOW_DATA_CMD, new ShowDataCommand());
	}

	public boolean execute(String input) {
		CommandParser cp = new CommandParser(input);
		Command command = commands.get(cp.getCmdKey());

		if (command == null) {
			terminal.println("Komanda nerasta");
			return false;
		}

		return command.execute(cp.getCmdArgs());
	}

}
