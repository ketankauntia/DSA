// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Sample Input
// 3
// 3

// Sample Output
// [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

import java.io.*;
import java.util.*;

public class C4_Get_Maze_Paths {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(getMazePaths(0, 0, m-1, n-1));
        sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            ArrayList<String> s1 = new ArrayList<>();
            s1.add("");
            return s1;
        } 

        // in this approch, boundary elements are violating rules. last column goin to next col even after boundry (not allowed). same for rows.
        // ArrayList<String> v = getMazePaths(sr, sc+1, dr, dc);
        // ArrayList<String> h = getMazePaths(sr+1, sc, dr, dc);
        ArrayList<String> horizontalPaths = new ArrayList<>();
        ArrayList<String> verticalPaths = new ArrayList<>();
        if(sc<dc){
            horizontalPaths = getMazePaths(sr, sc+1, dr, dc);
        }
        if(sr<dr){
            verticalPaths = getMazePaths(sr+1, sc, dr, dc);
        }

        ArrayList <String> expec = new ArrayList<>();

        for(String s : verticalPaths){{
            expec.add("v"+s);
        }}
        for(String s : horizontalPaths){{
            expec.add("h"+s);
        }}

        return expec;
    }

}