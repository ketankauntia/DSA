// 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
// 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
// 3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.

// Sample Input
// 6

// Sample Output
// 441

import java.io.*;
import java.util.*;

public class A14_Arrange_Buildings{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();

    //counting top side of the road (Exactly like prev. question)
    int oldCountOnes = 1;   
    int oldCountZeros = 1;
    
    for(int i=2;i<=n;i++){
        int newCountOnes = oldCountOnes+oldCountZeros;
        int newCountZeros = oldCountOnes;

        oldCountOnes=newCountOnes;
        oldCountZeros=newCountZeros;
    }
    int optionsInOneSide = oldCountOnes+oldCountZeros;

    //now to find all ways possible for both sides of the road, we square it.
    System.out.println( optionsInOneSide * optionsInOneSide);
    
    sc.close();
 }

}