package com.example.anagrams.finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.example.anagrams.reader.FileReader;
import com.example.anagrams.reader.TextFileReader;
import com.example.anagrams.utility.Utils;

/**
 * This class extends RecursiveTask class. 
 * This class is mainly used to process and find the anagram words.
 * It takes FileReader object to retrieve the list of words from an input file
 * and it uses the Fork/Join framework to split the file into some portions and
 * to work up them into smaller tasks when we are processing a huge file. 
 * return the list of anagram words.
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class AnagramFinderRecursiveTask extends RecursiveTask<List<Set<String>>>  {
	
	private static final long serialVersionUID = 1L;
	
	private FileReader fileReader;
	final int startLine;
	final int endLine;
	
	/* the THRESHOLD fix the number of number of words to be processed in one task */
    private static final int THRESHOLD = 1000000;
    
    /**
     * Constructor: initialize the FileReader object, 
     * the line to start reading from
     * and the line to end reading from
     * @param fileReader: The FileReader object
     */
    public AnagramFinderRecursiveTask(FileReader fileReader) {
        this.fileReader = fileReader;
        this.startLine = fileReader.getStartLine();
        this.endLine = fileReader.getEndLine();
    }
 
    /**
     * This method iterates the list of words and find and 
     * group together the list of anagram words.
     * The work can be done as a subtask when the number of words 
     * to be processed is greater than the THRESHOLD.
     * @return return the list of anagram word.
     */
    @Override
    protected List<Set<String>> compute() {
    	
    	Long fileSize = fileReader.getFileSize();
    	
    	/* if number of lists of words is greater than the THRESHOLD
    	 * 		then the work will be processed in subtask
    	 * else perform the work in one task
    	 */
        if (fileSize > THRESHOLD) {
        	List<Set<String>> forkedList = new ArrayList<Set<String>>();
			try {
				/* invoke and the joined the result from all the subtasks */
				forkedList = ForkJoinTask.invokeAll(createSubtasks())
				        .stream()
				        .map(ForkJoinTask::join)
				        .flatMap(List::stream)
				        .collect(Collectors.toList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* group together the anagram words from the joined result of all subtasks */
        	Map<String,List<Set<String>>> counting =  forkedList.stream()
                    .collect(Collectors.groupingBy(Utils::sortedSet));  	
        	        	
        	/* covert the result from Map<String,List<Set<String>>> to List<Set<String>> */
        	List<Set<String>> newList = new ArrayList<Set<String>>();
        	counting.values().stream()
        	.forEach(l -> 
        	newList.add(Utils.addSet(l))
        			);
        	
        	return newList;
        } else {
        	Map<String, Set<String>> process = processing(fileReader.readLines());
			return	process.values().stream().collect(Collectors.toList());
        }
    }
 
    /**
     * This method divides the file into two parts and 
     * returns them in smaller tasks to treat them in subtask
     * @return return a collection of subtask of AnagramFinderRecursiveTask object.
     */
    private Collection<AnagramFinderRecursiveTask> createSubtasks() throws IOException {
        List<AnagramFinderRecursiveTask> dividedTasks = new ArrayList<>();
        
        /* divides the file into two parts and 
         * add the first part of the divided file to the subtask*/
        dividedTasks.add(new AnagramFinderRecursiveTask(
        		
        		new TextFileReader(
        				fileReader.getPath(), 
        				fileReader.getStartLine(),
        				(int) (startLine + fileReader.getEndLine())/2)
        		
        		));
        
        /* divides the file into two parts and 
         * add the second part of the divided file to the subtask*/
        dividedTasks.add(new AnagramFinderRecursiveTask(

        		new TextFileReader(
        				fileReader.getPath(),
        				(int) (startLine + fileReader.getEndLine())/2, 
        				fileReader.getEndLine())
        		
        		));
        return dividedTasks;
    }
 
    /**
     * This method iterates through the parameter word list and 
     * group together the list of anagram words in map.
     * the key of the map and the words are grouped together 
     * based in sorting the character of the words
     * @return return the map of anagram words.
     */
    private Map<String, Set<String>> processing(List<String> listOfWords) {
        return listOfWords.stream()
                .flatMap(Pattern.compile("\\W+")::splitAsStream)
                .collect(Collectors.groupingBy(Utils::sorted, Collectors.toSet()));
    }

    
}