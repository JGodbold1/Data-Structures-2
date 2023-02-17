package HW2;

import java.util.Arrays;

import algs4.*;

public class TimeSymbolTables{
	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		SequentialSearchST <String, Integer> table1 = new SequentialSearchST<String, Integer>();
		BST<String, Integer> table2 = new BST<String, Integer>();
		BinarySearchST<String, Integer> table3 = new BinarySearchST<String, Integer>();
		
		int value = 0;
		Stopwatch timer = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (!table1.contains(words[i]))
				table1.put(words[i], 1);
			else 
				value++;
				table1.put(words[i], value);
		}
		StdOut.println("Time taken for SequentialSearchST " + timer.elapsedTime());
		
		int value2 = 0;
		Stopwatch timer2 = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (!table2.contains(words[i]))
				table2.put(words[i], 1);
			else 
				value2++;
				table2.put(words[i], value2);
		}
		StdOut.println("Time taken for BST " + timer2.elapsedTime());
		
		int value3 = 0;
		Stopwatch timer3 = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (!table3.contains(words[i]))
				table3.put(words[i], 1);
			else 
				value3++;
				table3.put(words[i], value3);
		}
		StdOut.println("Time taken for BinarySearchST " + timer3.elapsedTime());
	}
}