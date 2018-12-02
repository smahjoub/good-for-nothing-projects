package com.smahjoub.javapractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Some useful helpers for List class
 * @author smahjoub
 */
public class ListHelpers {
	
	/**
	 * Split given to list into a list of sublists. 
	 * @param inputList input list to split
	 * @param splitSize basically to sublist size
	 * @return a list of sublists
	 */
	public static List<List<Integer>> splitSubList(List<Integer> inputList, int splitSize) {
		argumentCheck(inputList, splitSize);
		
		List<List<Integer>> returnList = new ArrayList<>();
			
		for(int index = 0; index < inputList.size(); index += splitSize) {
			
			final int toIndex = (index + splitSize > inputList.size()) ? inputList.size() :  index + splitSize;
			List<Integer> subList = inputList.subList(index, toIndex);
			returnList.add(subList);
		}
		
		
		return returnList;
	}
	
	private static void argumentCheck(List<Integer> inputList, int splitSize) {
		if(inputList == null)
			throw new IllegalArgumentException("InputList should not be null");
		
		if(splitSize <= 0 || splitSize > inputList.size()) {
			throw new IllegalArgumentException("splitSize should not be negative or zero or greater than input list size");
		}
	}
}
