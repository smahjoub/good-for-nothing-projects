package com.smahjoub.javapractice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple SplitSubList method.
 */
public class SplitSubListTest {

	@Test
	public void normalBehaviorTest() {
		final List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 3, 5));
		final int splitSize = 2;

		assertEquals(ListHelpers.splitSubList(inputList, splitSize).size(), 4);
	}

	@Test
	public void subListSizeTest() {
		final List<Integer> inputList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		final int splitSize = 3;

		List<List<Integer>> output = ListHelpers.splitSubList(inputList, splitSize);
		
		assertEquals(output.size(), 2);
		
		assertEquals(output.get(0).size(), 3);
		
		assertEquals(output.get(1).size(), 2);
	}
}
