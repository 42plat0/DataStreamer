package datastreamer.command;

import java.util.List;

public interface Command {

	boolean execute(List<String> args);

	String getDescription();
}
