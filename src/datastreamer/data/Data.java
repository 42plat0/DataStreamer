package datastreamer.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Data {

	private int idx;
	private List<String[]> data;
	private String fileName;
	private String fileType;

}
