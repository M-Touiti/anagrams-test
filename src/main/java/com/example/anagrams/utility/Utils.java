package com.example.anagrams.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class contains methods that will be shared 
 * 
 * @author Mohamed TOUITI (mtouiti.info@gmail.com)
 */
public class Utils {

	/* This method sorts the string in the parameter */
	public static  String sorted(String s) {
		return (s == null ? null: 
         Stream.of(s.split("")).sorted().collect(Collectors.joining())
         );
    }
	
	/* This method sorts the set of string in the parameter */
	public static  String sortedSet(Set<String> set) {
    	String s = set.stream().findFirst().get();
        return Stream.of(s.split("")).sorted().collect(Collectors.joining());
    }
    
	/* This method converts a List<Set<String>> to a Set<String>*/
    public static Set<String> addSet(List<Set<String>> listOfSet) {
    	Set<String> l = new HashSet<String>();
    	
    	listOfSet.forEach(
    			set -> l.addAll(set)
    			);
    	
    	return l;
    }
}
