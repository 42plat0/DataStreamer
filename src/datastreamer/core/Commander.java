package datastreamer.core;

import java.util.HashMap;
import java.util.Map;

import datastreamer.command.Command;
<<<<<<< HEAD
import datastreamer.command.CommandList;
import datastreamer.command.CommandParser;
import datastreamer.command.impl.ExitCommand;
import datastreamer.command.impl.FunctionCommand;
import datastreamer.command.impl.LoadFilesCommand;
import datastreamer.command.impl.ShowCommandsCommand;
import datastreamer.command.impl.ShowDataCommand;
import datastreamer.command.impl.ShowFilesCommand;
=======
import datastreamer.command.ExitCommand;
import datastreamer.command.FileLoaderCommand;
import datastreamer.command.FunctionCommand;
import datastreamer.command.ShowFilesCommand;
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git

// TODO execute file input into mmemory
public class Commander {
	public final static String LOAD_FILE = "lf";

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
<<<<<<< HEAD
		commands.put(CommandList.EXIT_CMD, new ExitCommand());
		commands.put(CommandList.SHOW_FILES_CMD, new ShowFilesCommand(terminal, fileManager));
		commands.put(CommandList.FUNCTION_CMD, new FunctionCommand());
		commands.put(CommandList.SHOW_COMMANDS_CMD, new ShowCommandsCommand(terminal, commands));
		commands.put(CommandList.LOAD_FILES_CMD, new LoadFilesCommand(fileManager));
		commands.put(CommandList.SHOW_DATA_CMD, new ShowDataCommand());
=======
		commands.put(":q", new ExitCommand());
		commands.put("sf", new ShowFilesCommand(terminal, fileManager));
		commands.put("f", new FunctionCommand());
		commands.put(LOAD_FILE, new FileLoaderCommand(terminal, fileManager));
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git
	}

	public boolean execute(String input) {
<<<<<<< HEAD
		CommandParser cp = new CommandParser(input);
		Command command = commands.get(cp.getCmdKey());
=======
		CommandParser commandParser = new CommandParser(input);
		commandParser.parse(); // Important to have tho in design sucks

		Command command = commands.get(commandParser.getCommandKey());
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git

		if (command == null) {
			terminal.println("Komanda nerasta");
			return false;
		}

<<<<<<< HEAD
		return command.execute(cp.getCmdArgs());
=======
		String[] restArgs = commandParser.getRestArgs();

		if (restArgs.length > 0) {
			return command.execute(commandParser.getRestArgs());
		}

		return command.execute();
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git
	}

}
