package datastreamer.core;

import java.util.Arrays;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CommandParser {

	@Getter
	@Setter
	@NonNull
	private String inputText;

	private String commandKey = null;
	private String[] restArgs = null;

	public String getCommandKey() {
		if (commandKey == null) {
			return null;
		}

		return commandKey;
	}

	public String[] getRestArgs() {
		if (restArgs == null) {
			return null;
		}

		return restArgs;

	}

	public void parse() {
		if (inputText == null) {
			System.out.println("Komanda nerasta");
			return;
		}

		String[] inputTextArray = inputText.split(" ");

		commandKey = inputTextArray[0].trim();
		restArgs = Arrays.copyOfRange(inputTextArray, 1, inputTextArray.length);

	}

}
