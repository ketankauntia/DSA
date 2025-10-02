package algoforge.dynamic_programing;

public class introduction {
    
    // memoization
    public static int fibo_memo(int n, int[] memo){
        if( n<=1){
            return n;
        }

        if(memo[n]!=0){
            return memo[n];
        }

        int term1 = fibo_memo(n-1, memo);
        int term2 = fibo_memo(n-2, memo);

        int currTerm = term1+term2;

        memo[n] = currTerm;
        return currTerm;
    }


    // tabulation --------------------------
    // replace return with continue
    // replace recursive calls with dp states

    public static int fib_tab(int n, int[] dp){
        for(int i=0; i<=n; i++){
            if(i<=1){
                dp[i] = i;
                continue;
            }
            int term1 = dp[i-1];
            int term2 = dp[i-2];

            int currTerm = term1 + term2;

            dp[i] = currTerm;
        }
    }
}
