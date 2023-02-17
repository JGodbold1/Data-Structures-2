package HW1;

import java.util.Arrays;

import algs4.StdIn;
import algs4.StdOut;

public class FiveLetterWords{
	
	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		int count = 0;
		int flcount = 0;
		int vflcount = 0;
		String[] vowelwords = new String[words.length];
		
		
		for (int i = 0; i < words.length; i++) {
			if ((words[i].length())> 0) {
				count++;
			}
			if ((words[i]).length() == 5)  {
				flcount++;
			}
			if (((words[i]).length() == 5) & ((words[i].startsWith("a")||(words[i].startsWith("e"))||(words[i].startsWith("i")))||(words[i].startsWith("o"))||(words[i].startsWith("u")))) {
				vflcount++;
				vowelwords[vflcount] = (words[i]);
			}
		}
		for (int i = 0; i < words.length; i++) {
			vowelwords[vflcount] = (words[i]);
		}
		Arrays.sort(words);
		StdOut.println("Jayden Godbold***");
		StdOut.println("There are " + count + " words in this file.");
		StdOut.println("There are " + flcount + " five letter words in this file.");
		StdOut.println("There are " + vflcount + " five letter words that start with a vowel in this file.");
		StdOut.println("all five letter words that start with a vowel in this file. ");
		//i was trying to print out at least the array that i made but it prints null for everything
		StdOut.println("First word: " + vowelwords[0]);
		StdOut.println("Last word: " + vowelwords[vowelwords.length-1]);
	}
	

}