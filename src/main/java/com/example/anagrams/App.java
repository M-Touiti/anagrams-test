package com.example.anagrams;

import com.example.anagrams.filemanager.AnagramTextFileManager;
import com.example.anagrams.filemanager.FileManager;

/**
 * Anagram App.
 *
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class App {
	
	public final static String DEFAULT_PATH = "src/main/resources/sample.txt";

	public static void main(String[] args) {
		
		FileManager fileManager;
		
		if(args.length>0) {
			fileManager = new AnagramTextFileManager(args[0]);
		}else {
			fileManager = new AnagramTextFileManager(DEFAULT_PATH);
		}
		
		fileManager.find();
		fileManager.display();
	}

}
