package com.smahjoub.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java practice test
 * @author smahjoub
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Java practice test!" );
        
        final List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 3, 5));
        final int splitSize = 2;
       
        final List<List<Integer>> output = ListHelpers.splitSubList(inputList, splitSize);
        
        System.out.println( "Sublist size :"  + output.size()); 
    }
}
