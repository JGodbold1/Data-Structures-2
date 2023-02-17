//Jayden Godbold
package TranslateCodons;

import algs4.ST;
import algs4.StdIn;
import algs4.StdOut;

public class TranslateCodons{
	public static void main(String[] args) {
		// general print statements
		StdOut.println("Jayden Godbold***");
		StdOut.println(" ");
				
		//creation of the symbol table
		ST<String, String> codonToAATable = new ST<String, String>();
		
		//import of file to read
		StdIn.fromFile("data/smallsequences.txt");
		
		//hard code of amino acids and responding codes, could be simplified if i searched codontoaa.text, however it would print out the full names instead the the 3 letter abbreviation. 
		codonToAATable.put("ATG", "Met");
		codonToAATable.put("TTC", "Phe");
		codonToAATable.put("ATT", "Ile");
		codonToAATable.put("AAC", "Asn");
		codonToAATable.put("CGA", "Arg");
		codonToAATable.put("TGA", "Stp");
		codonToAATable.put("CTG", "Leu");
		codonToAATable.put("TTT", "Phe");
		codonToAATable.put("TCC", "Ser");
		codonToAATable.put("ACC", "Thr");
		codonToAATable.put("AAA", "Lys");
		
		// loop to read lines and split into two variables, first is the name, second is the string of acid codes
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine(); // reads lines in the file one by one
			String[] fields = line.split("\\t"); // splits the contents of the file into indexes that can be isolated to variables
			String aminoN = fields[0]; // Acid name
			String aminoS = fields[1]; // String of acid codes
			
			//prints name of acid, prints bar before next name
			StdOut.println("-----------------------");
			StdOut.println(aminoN); // prints acid name
			
		//loop to iterate through table
		for (String key : codonToAATable.keys()){ //iterates through key list
			if(aminoS.contains(key)) { // checks if key in contained in the acid code string
				StdOut.println(key + " " + codonToAATable.get(key)); // prints out results in alphabetical order
				}
			}
		}
		
	}
	
}
