// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
// Use sample input and output to take idea about output.

import java.io.*;
import java.util.*;

public class C3_Get_Stairs_Path {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
        sc.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if(n==0){
            ArrayList<String> s1 = new ArrayList<>();
            s1.add("");
            return s1;
        } else if(n<0){ //negative steps cannot be taken
            ArrayList <String> s1 = new ArrayList<>();
            return s1;
        }

        //this gives all the possible paths for 1 step, 2 steps, 3 steps.
        ArrayList <String> paths1 = getStairPaths(n-1);
        ArrayList <String> paths2 = getStairPaths(n-2);
        ArrayList <String> paths3 = getStairPaths(n-3);

        ArrayList <String> finalPath = new ArrayList<>();

        for(String p : paths1){
            finalPath.add(1+p);
        }
        for(String p : paths2){
            finalPath.add(2+p);
        }
        for(String p : paths3){
            finalPath.add(3+p);
        }
        return finalPath;
    }

}