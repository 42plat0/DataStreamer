package datastreamer.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileManager {
	private File folder = null;

	public List<String> listFiles() {
		List<File> files = getFolderFiles();

		if (files == null) {
			return List.of();
		}
		String[] list = new String[files.size()];

		for (int i = 0; i < list.length; i++) {
			list[i] = files.get(i).getName();
		}
		return List.of(list);
	}

	private List<File> getFolderFiles() {
		if (folder == null) {
			return null;
		}
		return Arrays.asList(folder.listFiles());
	}

	public List<String[]> readFile(String fileName) {

		File file = getFolderFiles().stream().filter(f -> f.getName().equals(fileName)).reduce((a, b) -> {
			System.out.println("Found more than one, returning null");
			return null;
		}).orElse(null);

		try (FileReader fileReader = new FileReader(file); CSVReader csvReader = new CSVReader(fileReader)) {
			csvReader.skip(1);
			List<String[]> list = csvReader.readAll();
			return list;
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
		return null;
	}

}
