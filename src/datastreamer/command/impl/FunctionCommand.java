package datastreamer.command.impl;

import java.util.List;

import datastreamer.command.Command;

public class FunctionCommand implements Command {

	@Override
	public boolean execute(List<String> args) {
		// TODO Auto-generated method stub
		System.out.println("Funkcija");
		return false;
	}

	@Override
	public String getDescription() {
		return "Funkcija";
	}

}
