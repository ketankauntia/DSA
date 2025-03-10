import java.util.*;
public class code_nov_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = solve(n);
        System.out.println(ans);
        sc.close();
    }

    public static int solve1(int input1){
        if(input1<4){
            return 1;
        }
        System.out.println("ran for :"+input1);
        // TN = (n/3) + 2*(n/2) + 5*n
        int p1 = solve(input1 / 3);
        int p2 = 2*solve(input1 / 2);
        int p3 = 5*input1;
        int total = (p1+p2+p3);

        return total% 1_000_000_007;
    }

    // tabulation form
    public static int solve(int input1){
        //step 1 storage
        int dp[]=new int[input1+1];

        //step 2 : find direction 
        // direction is 0 to n
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        System.out.println("ran for :"+input1);
        if(input1<4){
            dp[input1]=1;
        } 

        for(int i=4;i<=input1;i++){
            dp[i]=dp[i/3]+(dp[i/2]*2)+(i*5);
        }

        return dp[input1];
    }
}


