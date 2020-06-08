package com.example.anagrams.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.junit.Test;

import com.example.anagrams.reader.FileReader;
import com.example.anagrams.reader.TextFileReader;

/**
 * Unit tests for TextFileReaderTest class.
 *
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class TextFileReaderTest {
	
	/**
     * Should throw IOException. ghostFile doesn't exist.
     */
    @Test
    public void shouldThrowIOException() {
        assertThrows(
                IOException.class,() -> {
                    new TextFileReader("src/main/resources/ghostFile.txt");
                }
        );
    }

    /**
     * Should be able to read a 7 lines (words) file.
     */
    @Test
    public void shouldReadTextLinesFiles() {
    	try {
			FileReader fileReader = new TextFileReader("src/test/resources/sample.txt");
			assertEquals(7, fileReader.getFileSize().intValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Should be able to read a 7 lines (words) file.
     */
    @Test
    public void shouldRetunTextLinesFiles() {
    	try {
			FileReader fileReader = new TextFileReader("src/test/resources/sample.txt");
			assertEquals(7, fileReader.readLines().size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Should be able to read a 2 lines (words) of a file.
     */
    @Test
    public void shouldTextLinesFiles() {
			FileReader fileReader;
			try {
				fileReader = new TextFileReader("src/test/resources/sample.txt"
						, 0 , 2);
				assertEquals(2, fileReader.readLines().size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
    }
    
    /**
     * Should throw IOException. ghostFile doesn't exist.
     */
    @Test
    public void startLineIllegalArgumentException() {
        assertThrows(
        		IllegalArgumentException.class,() -> {
                    new TextFileReader("src/test/resources/sample.txt", -1 , 2);
                }
        );
    }

}

