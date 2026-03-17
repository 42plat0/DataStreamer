package datastreamer.command.impl;

import java.util.List;
import java.util.Map;

import datastreamer.command.Command;
import datastreamer.core.Context;
import datastreamer.core.FileManager;
import datastreamer.model.PersonDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoadFilesCommand implements Command {

	private FileManager fileManager;

	@Override
	public boolean execute(List<String> args) {
		// TODO Auto-generated method stub
		if (args.isEmpty()) {
			System.out.println("Turite pateikti failo pavadinimą iš sąrašo");
			System.out.println("Galimų įkelti failų pavadinimus rasite iškvietę komandą :sf");
			return false;
		}

		List<String> fileList = fileManager.listFiles();
		if (!fileList.equals(args)) {
			System.out.println("Bus įkeliami tik rasti failai");
		}

		args = args.stream().filter(arg -> fileList.contains(arg)).toList();
		Map<String, List<PersonDTO>> data = Map.of(args.getFirst(),
				PersonDTO.getPersonListFromCSVData(fileManager.readFile(args.getFirst())));

		Context.insertData(data);
		System.out.println("Sėkmingai įkelti duomenys.");
		return false;
	}

	@Override
	public String getDescription() {
		return "Loads a specified file into memory";
	}

}
