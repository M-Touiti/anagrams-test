package com.example.anagrams.finder;

import java.util.List;
import java.util.Set;

/**
 * This interface allows to find an return a list of desired words.
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public interface WordFinder {

	List<Set<String>> find();
}
