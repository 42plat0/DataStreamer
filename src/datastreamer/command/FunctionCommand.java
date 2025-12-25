package datastreamer.command;

public class FunctionCommand implements Command {

	@Override
	public boolean execute() {
		System.out.println("Funkcija");

		return false;
	}

	@Override
	public String getDescription() {
		return "Funkcija";
	}

	@Override
	public boolean execute(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
