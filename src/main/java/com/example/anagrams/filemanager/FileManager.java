package com.example.anagrams.filemanager;

import java.util.List;
import java.util.Set;

import com.example.anagrams.finder.WordFinder;
import com.example.anagrams.reader.FileReader;

/**
 * This class implements WordFinder interface. 
 * It takes in the parameter the path to the input file
 * It uses FileReader to retrieve the list of words from the file
 * It uses the method find() to find and 
 * return the list of desired words
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public abstract class FileManager {
	
	/* the path to the text file */
	private final String path;
	
	/* used to retrieve */
	private FileReader fileReader;
	
	/* used to find the list of desired words*/
	private WordFinder wordFinder;
	
	/* list of desired words*/
	private List<Set<String>> wordsFound;

	/**
     * Constructor: initialize the path to the text file.
     * @param path Path to the text file.
     */
	public FileManager(String path) {
		super();
		this.path = path;
	}
	
	/**
     * this method iterates the file word list and find the list of desired words
     */
	public void find() {
		this.wordsFound = this.wordFinder.find();
	}
	
	/**
     * Display the list of words found
     */
	public void display() {
		this.wordsFound.stream()
		.forEach(list -> System.out.println(String.join(" ", list)));
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public WordFinder getWordFinder() {
		return wordFinder;
	}

	public void setWordFinder(WordFinder wordFinder) {
		this.wordFinder = wordFinder;
	}	

	public List<Set<String>> getWordsFound() {
		return wordsFound;
	}

	public void setWordsFound(List<Set<String>> wordsFound) {
		this.wordsFound = wordsFound;
	}

	public String getPath() {
		return path;
	}

	
}
