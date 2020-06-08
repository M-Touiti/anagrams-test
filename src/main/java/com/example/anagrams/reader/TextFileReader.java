package com.example.anagrams.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class allows to read words in a text file.
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class TextFileReader implements FileReader{

	private final String path;
    private final int startLine;
    private final int endLine;
    
    /* contain a list of words of the chosen file */
	private List<String> words;    

    /**
     * Constructor: Read content of a text file.
     * @param path Path to the text file.
     * @throws IOException If path is not found.
     */
    public TextFileReader(String path) throws IOException {
        try {
        	BufferedReader reader = Files.newBufferedReader(Paths.get(path));
            words = reader.lines().collect(Collectors.toList());
        	this.path = path;
        	this.startLine=0;
        	this.endLine=words.size();
        } catch (IOException e) {
            throw new IOException("File is not found");
        }        
    }   
    
    /**
     * Constructor: Read a portion of a text file from a startLine to endLine.
     * @param path Path to the text file.
     * @param startLine Line Number to start reading from.
     * @param endLine Line Number to end reading to.
     * @throws IllegalArgumentException If Line Number is out of file line boundary.
     * @throws IOException If path is not found.
     */
    public TextFileReader(String path, final int startLine, final int endLine) throws IOException {
	
		if(startLine<0) {
			new IllegalArgumentException("Error: startLine is negative.");
		}
    	
    	this.path = path;
	    this.startLine=startLine;
    	this.endLine=endLine;
    	
        final long skip = (long) (startLine);
	    final long limit = (long) (endLine - startLine);
	    final Path filePath = Paths.get(path);
	    
	    try (
	        final Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8);
	    ) {
	        words = stream.skip(skip).limit(limit)
	            .collect(Collectors.toList());
	    }catch (IOException e) {
            throw new IOException("File is not found");
        } 
    }
    
    /**
     * @return the number of words in the file
     */
    public Long getFileSize() {
    	return Long.valueOf(words.size());
    }

    /**
     * @return List of all words in the file
     */
    public List<String> readLines() {
        return words;
    }

    /**
     * @return the path of the file
     */
	public String getPath() {
		return path;
	}

	/**
     * @return the line number to start reading from
     */
	public int getStartLine() {
		return startLine;
	}

	/**
     * @return the line number to end reading from
     */
	public int getEndLine() {
		return endLine;
	}
    
    
}
