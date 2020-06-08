package com.example.anagrams.finder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import com.example.anagrams.reader.FileReader;

/**
 * This class implements WordFinder interface. 
 * It takes FileReader object to retrieve the list of words from an input file
 * After, it uses the method find() to find and 
 * return the list of desired word (in this case the anagram words)
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class AnagramFinder implements WordFinder {
	
	/* this object will be used to retrieve the list of words from an input file */
	private final FileReader fileReader;

	/**
     * Constructor: initialize the FileReader object
     * @param fileReader: The FileReader object
     */
	public AnagramFinder(FileReader fileReader) {
		super();
		this.fileReader = fileReader;
	}

	/**
     * this method iterates the list of words and find and group together 
     * the list of desired words (anagram words in this case)
     * @return return the list of desired word (in this case the anagram words).
     */
	@Override
	public List<Set<String>> find() {
		
		/* the Fork/Join framework used to split the file into some portions and
		 * to work up them into smaller tasks when we are processing a huge file
		 */
		ForkJoinPool fjp = new ForkJoinPool(); 
		
		/* initialize the AnagramFinder Recursive Task */
		AnagramFinderRecursiveTask anagramFinderRecursiveTask = new AnagramFinderRecursiveTask(
				fileReader);
		
		/* invoke the ForkJoinPool Recursive Task to return the grouped list of words */
		List<Set<String>>  anagramsWords = fjp.invoke(anagramFinderRecursiveTask); 
		
		/* filter the grouped list to return only the anagram words */
		return anagramsWords.stream()
				.filter(list -> list.size() > 1)
				.collect(Collectors.toList());
	}

	
}
