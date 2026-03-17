package datastreamer.command.impl;

import java.util.List;

import datastreamer.command.Command;
import datastreamer.core.Context;

public class ShowDataCommand implements Command {

	@Override
	public boolean execute(List<String> args) {
		Context.printData();
		return false;
	}

	@Override
	public String getDescription() {
		return "Shows already loaded data in-memory";
	}

}
