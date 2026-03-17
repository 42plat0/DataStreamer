package datastreamer.command.impl;

import java.util.List;

import datastreamer.command.Command;

public class ExitCommand implements Command {

	@Override
	public boolean execute(List<String> args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		return "Exits program";
	}

}
