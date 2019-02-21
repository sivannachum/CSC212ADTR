package edu.smith.cs.csc212.adtr;

import java.awt.List;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		/**
		 * Make left and right into lists
		 * then iterate over their contents and add them to the output set
		 * Any duplicates will only appear once in the set
		 */
		ListADT<Integer> leftListADT = left.toList();
		for (Integer i : leftListADT) {
			output.insert(i);
		}
		ListADT<Integer> rightListADT = right.toList();
		for (Integer i : rightListADT) {
			output.insert(i);
		}
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		
		return output;
	}
}
