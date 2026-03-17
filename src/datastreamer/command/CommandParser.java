package datastreamer.command;

import java.util.List;

import lombok.Getter;

public class CommandParser {

	private String input;
	@Getter
	private String cmdKey;
	@Getter
	private List<String> cmdArgs;

	public CommandParser(String input) {
		this.input = input;
		parse();
	}

	private void parse() {
		if (input == null || input.isBlank()) {
			cmdKey = "";
			cmdArgs = List.of();
			return;
		}
		String[] parts = input.trim().split("\\s+"); // Split on any whitespace char

		cmdKey = parts[0];
		cmdArgs = List.of(parts).subList(1, parts.length); // remove cmdKey
	}

}
