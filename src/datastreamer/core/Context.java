package datastreamer.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import datastreamer.model.PersonDTO;
import lombok.Getter;

public class Context {

	@Getter
	private static Map<String, List<PersonDTO>> data = new HashMap<>();

	private static Context INSTANCE = null;

	private Context() {
	};

	public static Context getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Context();
		}

		return INSTANCE;
	}

	public static void insertData(Map<String, List<PersonDTO>> insData) {
		for (Entry<String, List<PersonDTO>> entry : insData.entrySet()) {
			data.put(entry.getKey(), entry.getValue());
		}
	}

	public static void printData() {
		if (data.entrySet().isEmpty()) {
			System.out.println("There is no data in-memory. Load some.");
		}
		for (Entry<String, List<PersonDTO>> entry : data.entrySet()) {
			System.out.print("Data from file: ");
			System.out.println(entry.getKey());
			entry.getValue().stream().forEach(System.out::println);
		}
	}

}
