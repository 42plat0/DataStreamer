package datastreamer.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datastreamer.data.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileManager {
	private File folder = null;

	public String[] listFiles() {
		File[] files = getFolderFiles();

		if (files == null) {
			return new String[0];
		}
		String[] list = new String[files.length];

		for (int i = 0; i < list.length; i++) {
			list[i] = files[i].getName();
		}
		return list;
	}

	private File[] getFolderFiles() {
		if (folder == null) {
			return null;
		}
		return folder.listFiles();
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
