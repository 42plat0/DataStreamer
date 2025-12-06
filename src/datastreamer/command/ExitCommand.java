package datastreamer.command;

public class ExitCommand implements Command {
	public static final String KEYWORD = "end";

	@Override
	public boolean execute() {
		return true;
	}

	@Override
	public String getDescription() {
		return "Exits program";
	}

}
