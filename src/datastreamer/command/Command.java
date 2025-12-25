package datastreamer.command;

public interface Command {

	/**
	 * 
	 * @return boolean: false - terminate program, true - keep it running
	 */
	boolean execute();

	/**
	 * 
	 * @return boolean: false - terminate program, true - keep it running
	 */
	boolean execute(String[] args);

	String getDescription();
}
