//Jayden Godbold
package Connected;

import java.util.Random;
import algs4.CC;
import algs4.Graph;
import algs4.StdOut;

public class Connected{
	public static void main(String[]args){
		Random rnum = new Random();
		for(int n=32; n <= 256; n*=2){
			float edges = 0;
			for(int i = 0; i<1000; i++) {
				Graph g = new Graph(n);
				CC cc = new CC(g);
				while(cc.count() !=1) {
					int u = rnum.nextInt(n);
					int v = rnum.nextInt(n);
					g.addEdge(u, v);
					cc = new CC(g);
				}
				edges += g.E();
			}
			float average = edges/1000;
			StdOut.println(n + " " + average);
		}
	}
}