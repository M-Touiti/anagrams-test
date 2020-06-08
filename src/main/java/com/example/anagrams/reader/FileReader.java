package com.example.anagrams.reader;

import java.util.List;

/**
 * This interface allows to read words in a text file.
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public interface FileReader {

	List<String> readLines();
	Long getFileSize();
	public int getStartLine();
	public int getEndLine();
	public String getPath();
}
