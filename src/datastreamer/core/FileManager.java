package datastreamer.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> branch 'main' of git@github.com:42plat0/DataStreamer.git

import datastreamer.data.Data;
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

	public File[] getFiles(String[] fileNames) {
		File[] files = getFolderFiles();
		List<File> matchingFiles = new ArrayList<File>();

		// TODO optimize this someday. files could be a map with name as key
		for (File file : files) {
			for (String fileName : fileNames) {
				if (fileName.equals(file.getName())) {
					matchingFiles.add(file);
				}
			}
		}

		return matchingFiles.toArray(File[]::new);

	}

	public List<Data> getFilesInFormat(String[] fileNames) {
		List<Data> data = List.of();

		File[] files = getFiles(fileNames);

		for (File file : files) {
			System.out.println("File: -- " + file.getName() + " , " + file.getAbsolutePath());
			// read csv file and put data to cache through data object
			Data newData = new Data(0, readFile(file.getAbsolutePath()), file.getName(), getFileType(file.getName()));
		}

		return data;
	}

	private String getFileType(String name) {
		return name.split(".")[1];
	}

	public static List<String[]> readFile(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);

			String line = br.readLine(); // remove headers
			List<String[]> readVals = new ArrayList<String[]>();

			while ((line = br.readLine()) != null) {
				String[] rowVals = line.split(",");
				readVals.add(rowVals);
			}
			return readVals;

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
