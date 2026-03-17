package datastreamer.model;

import java.util.List;

public record PersonDTO(Long id, String firstName, String lastName, String email, String gender, String country,
		String domain, String birthDate) {

	public static List<PersonDTO> getPersonListFromCSVData(List<String[]> csvData) {
		return csvData.stream().map(line -> {
			String lineId = line[0];
			String firstName = line[1];
			String lastName = line[2];
			String email = line[3];
			String gender = line[4];
			String country = line[5];
			String domain = line[6];
			String birthDate = line[7];
			return new PersonDTO(Long.valueOf(lineId), firstName, lastName, email, gender, country, domain, birthDate);
		}).toList();
	}

	@Override
	public String toString() {
		return "-%d. %s | %s | %s | %s | %s | %s | %s".formatted(id, firstName, lastName, email, gender, country,
				domain, birthDate);
	}
}
