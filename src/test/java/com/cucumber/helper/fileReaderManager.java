package com.cucumber.helper;

public class fileReaderManager {

	public static fileReaderManager fr = new fileReaderManager();
	public static configReader cr;

	public configReader getconfigReader() throws Throwable {
		if (cr == null) {
			cr = new configReader();
		}
		return cr;
	}

	public static fileReaderManager getInstance() {
		return fr;
	}

	private fileReaderManager() {
	 }

}
