// 1. There are 3 towers. Tower 1 has n disks, where n is a positive number. Tower 2 and 3 are empty.
// 2. The disks are increasingly placed in terms of size such that the smallest disk is on top and largest disk is at bottom.
// 3. You are required to 
//     3.1. Print the instructions to move the disks.
//     3.2. from tower 1 to tower 2 using tower 3 
//     3.3. following the rules
//         3.3.1 move 1 disk at a time.
//         3.3.2 never place a smaller disk under a larger disk.
//         3.3.3 you can only move a disk at the top.

// Sample Input
// 3
// 10
// 11
// 12

// Sample Output
// 1[10 -> 11]
// 2[10 -> 12]
// 1[11 -> 12]
// 3[10 -> 11]
// 1[12 -> 10]
// 2[12 -> 11]
// 1[10 -> 11]

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.


import java.io.*;
import java.util.*;

public class A8_Tower_Of_Hanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner (System.in);
        int n=sc.nextInt();
        int t1=sc.nextInt();
        int t2=sc.nextInt();
        int t3=sc.nextInt();
        toh(n,t1,t2,t3);
        sc.close();
        
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        
        if(n==0){
            return;
        }

        // faith : for every n-1 disks will be correctly shifted from a to c using b
        //expection : for every n-1 remaning disk will be correctly shifted from c to a using b
     
        toh(n-1,t1id,t3id,t2id);    //left shift
        System.out.println(n+"["+ t1id +"->"+ t2id +"]");
        toh(n-1,t3id,t2id,t1id);    //right shift
    }

}