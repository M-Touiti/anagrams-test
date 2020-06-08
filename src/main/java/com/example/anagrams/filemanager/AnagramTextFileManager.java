package com.example.anagrams.filemanager;

import java.io.IOException;

import com.example.anagrams.finder.AnagramFinder;
import com.example.anagrams.reader.TextFileReader;

/**
 * This class represents an implementation of the strategy design pattern
 * it extends FileManager class. 
 * It sets TextFileReader object to the FileReader attribute
 * and that is in the aims to retrieve the list of words from a TEXT file.
 * It sets, also, AnagramFinder object to the WordFinder attribute
 * and that is in the aims to find and display the list of ANAGRAM words.
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class AnagramTextFileManager extends FileManager {

	/**
     * Constructor: initialize the path, 
     * set and initialize the TextFileReader to the FileReader attribute
     * set and initialize the AnagramFinder to the WordFinder attribute
     * @param path Path to the text file.
     */
	public AnagramTextFileManager(String path) {
		super(path);
		
		try {
			this.setFileReader(new TextFileReader(path) );
			
			this.setWordFinder(new AnagramFinder(this.getFileReader()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
