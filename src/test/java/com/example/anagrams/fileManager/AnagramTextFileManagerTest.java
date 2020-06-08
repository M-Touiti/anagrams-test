package com.example.anagrams.fileManager;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.example.anagrams.filemanager.AnagramTextFileManager;
import com.example.anagrams.filemanager.FileManager;

/**
 * Unit tests for AnagramTextFileManagerTest class.
 *
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class AnagramTextFileManagerTest {

	/**
     * Find the anagram word in an empty file. Should return 0 List of Anagram words.
	 * @throws IOException 
     */
    @Test
    public void findAnagramWordInEmptyFile() throws IOException {
    	FileManager fileManager = new AnagramTextFileManager("src/test/resources/empty.txt");
    	fileManager.find();
    	assertEquals(0, fileManager.getWordsFound().size());
    }
    
    /**
     * Find the anagram word in the file. Should return 2 List of Anagram words.
	 * @throws IOException 
     */
    @Test
    public void findAnagramWord() throws IOException {
    	FileManager fileManager = new AnagramTextFileManager("src/test/resources/sample.txt");
    	fileManager.find();
    	assertEquals(2, fileManager.getWordsFound().size());
    }
}

