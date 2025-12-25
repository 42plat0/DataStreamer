package datastreamer.core;

import java.util.ArrayList;
import java.util.List;

import datastreamer.data.Data;

public class Cache {
	private static Cache cache = null;

	private List<Data> data = new ArrayList<Data>();

	private Cache() {
	}

	public static Cache getInstance() {
		if (cache == null) {
			cache = new Cache();
		}

		return cache;
	}

	public List<Data> getData() {
		return data;
	}

	public void addData(Data data) {
		this.data.add(data);
	}

	public void addData(List<Data> data) {
		this.data.addAll(data);
	}

}
