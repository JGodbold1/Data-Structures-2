//Jayden Godbold 
package TestTraversal;

import algs4.BSTEssentialV2;
import algs4.StdIn;
import algs4.StdOut;

public class TestTraversal{
	public static void main(String[]args){
		
		//creation of the symbol table
		BSTEssentialV2<String, Integer> table1 = new BSTEssentialV2<String, Integer>();
		
		//import of file to read
		StdIn.fromFile("data/tale.txt");
		//string array of Strings in tinytale.txt
		String[] words = StdIn.readAllStrings();
		
		//for loop to create table
		for (int i = 0; i < words.length; i++) {
			int value = 1;
			if (!table1.contains(words[i]))
				table1.put(words[i], 1);
			else 
				table1.put(words[i], table1.get(words[i])+value);
		}
		
		 StdOut.println("Numbers that show up once:" + table1.countValue(1));
		 StdOut.println("Numbers that show up Three times:" + table1.countValue(3));
		 StdOut.println("Numbers that show up Ten Times:" + table1.countValue(10));
	}
}