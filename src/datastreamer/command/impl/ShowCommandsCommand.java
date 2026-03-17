package datastreamer.command.impl;

import java.util.List;
import java.util.Map;

import datastreamer.command.Command;
import datastreamer.core.StreamerTerminal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShowCommandsCommand implements Command {

	private StreamerTerminal terminal;
	private Map<String, Command> commands;

	@Override
	public boolean execute(List<String> args) {
		terminal.println("Here are all executable commands");
		commands.entrySet().forEach(e -> terminal.println("    " + e.getKey() + " - " + e.getValue().getDescription()));

		return false;
	}

	@Override
	public String getDescription() {
		return "Shows all executable commands";
	}

}
