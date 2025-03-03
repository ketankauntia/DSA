import java.util.Scanner;

public class TestCode {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt();
        // int n = sc.nextInt();
        System.out.println("Enter base number:");
        int x = sc.nextInt();
        System.out.println("Enter power:");
        int n = sc.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
        sc.close();
    }

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }
        // expectation
        // x ko n(5) times

        // faith : x ko n(4) times ho jayega
        int faith = power(x, n - 1);
        int expec = x * faith;

        return expec;
    }

}
