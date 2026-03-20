package datastreamer.command;

import java.util.List;

public interface Command {

<<<<<<< HEAD
	boolean execute(List<String> args);
=======
	/**
	 * 
	 * @return boolean: false - terminate program, true - keep it running
	 */
	boolean execute();
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git

	/**
	 * 
	 * @return boolean: false - terminate program, true - keep it running
	 */
	boolean execute(String[] args);

	String getDescription();
}
