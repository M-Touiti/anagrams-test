package com.example.anagrams.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit tests for UtilsTest class.
 *
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class UtilsTest {
	
	/**
     * The word argument is a null. Should return null.
     */
    @Test
    public void sortNullWord() {;
    	assertNull(Utils.sorted(null));
    }
    
    /**
     * The word argument is an empty string. Should return empty String.
     */
    @Test
    public void sortEmptyWord() {;
    	assertEquals("", Utils.sorted(""));
    }

    /**
     * The word argument is a one character. Should return the same character.
     */
    @Test
    public void sortCharacter() {
    	assertEquals("a", Utils.sorted("a"));
    }
    
    /**
     * The word argument built with a same character. Should return the same word.
     */
    @Test
    public void sortSameCharacterWord() {
    	assertEquals("aaa", Utils.sorted("aaa"));
    }
    
    /**
     * The word argument built with a same character. Should return the same word.
     */
    @Test
    public void sortWord() {
    	assertEquals("act", Utils.sorted("cat"));
    	assertEquals("acer", Utils.sorted("race"));
    }
}
