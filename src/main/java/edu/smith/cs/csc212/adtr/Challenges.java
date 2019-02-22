package edu.smith.cs.csc212.adtr;

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
		/**
		 * Convert the left set to a list
		 * Check to see which of its contents are in the right set
		 * Add those to the output set
		 */
		ListADT<Integer> leftListADT = left.toList();
		for (Integer i : leftListADT) {
			if (right.contains(i)) {
				output.insert(i);
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		/**
		 * Go through all the words in the list.
		 * If they are already in the map, add 1 to the value they map to.
		 * If they are not in the map, map them to one.
		 */
		for (String i : words) {
			Integer before = output.get(i);
			if (before == null) {
				output.put(i, 1);
			}
			else {
				output.put(i, before + 1);
			}
		}
		return output;
	}
	
}