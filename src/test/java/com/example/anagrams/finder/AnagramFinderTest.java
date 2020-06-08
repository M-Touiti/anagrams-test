package com.example.anagrams.finder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.example.anagrams.reader.FileReader;
import com.example.anagrams.reader.TextFileReader;

/**
 * Unit tests for AnagramFinderTest class.
 *
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class AnagramFinderTest {
	
	/**
     * Find the anagram word in an empty file. Should return 0 List of Anagram words.
	 * @throws IOException 
     */
    @Test
    public void findAnagramWordInEmptyFile() throws IOException {
    	FileReader fileReader = new TextFileReader("src/test/resources/empty.txt");
    	AnagramFinder anagramFinder = new AnagramFinder(fileReader);
    	assertEquals(0, anagramFinder.find().size());
    }
    
    /**
     * Find the anagram word in the file. Should return 2 List of Anagram words.
	 * @throws IOException 
     */
    @Test
    public void findAnagramWord() throws IOException {
    	FileReader fileReader = new TextFileReader("src/test/resources/sample.txt");
    	AnagramFinder anagramFinder = new AnagramFinder(fileReader);
    	assertEquals(2, anagramFinder.find().size());
    }
}
