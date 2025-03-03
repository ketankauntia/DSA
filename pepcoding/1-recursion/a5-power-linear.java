// 1. You are given a number x.
// 2. You are given another number n.
// 3. You are required to calculate x raised to the power n. Don't change the signature of power function .

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

// import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
        // sc.close();
    }

    public static int power(int x, int n) {

        // expectation
        // x ko n(5) times

        // faith : x ko n(4) times ho jayega
        int faith = power(x, n - 1);

        int expec = x * faith;

        return expec;
    }

}