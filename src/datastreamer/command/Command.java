package datastreamer.command;

public interface Command {

	boolean execute();

	String getDescription();
}
