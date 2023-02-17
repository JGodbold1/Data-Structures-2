package ShortestPaths;

import algs4.BreadthFirstPaths;
import algs4.Graph;
import algs4.In;

public class ShortestPaths {
    public static void main(String[] args) {
        In data = new In("data/KBgraph.txt");
        Graph g  = new Graph(data);
        BreadthFirstPaths paths = new BreadthFirstPaths(g, 4);
        System.out.println("Vertex  :  Distance  :  Path");
        for (int i = 0; i < 19; i++) {
            System.out.printf("   %d   :     %d     :     ", i, paths.distTo(i));
            System.out.println(paths.pathTo(i));
            }
        }
    }