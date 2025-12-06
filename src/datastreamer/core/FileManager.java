package datastreamer.core;

import java.io.File;

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

}
