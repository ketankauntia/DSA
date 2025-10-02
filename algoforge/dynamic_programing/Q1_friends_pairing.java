package algoforge.dynamic_programing;

public class Q1_friends_pairing {
    public long countFriendsPairings_rec(int n, long[] memo) {
        // code here
        
        if(n<=2) return memo[n] = n;

        if(memo[n]!=0){
            return memo[n];
        }

        long single = countFriendsPairings_rec(n-1, memo);
        long pairUp = (n-1)*countFriendsPairings_rec(n-2, memo);

        return single+pairUp;
    }

    public long countFriendsPairings_tab(int N, long[] dp){
        for(int n=1; n<=N; n++){
            if(n<=2){
                dp[n] = n;
                continue;
            }

            long single = dp[n-1];
            long pairUp = (n-1)*dp[n-2];

            dp[n] = single+pairUp;
        }
        return dp[N];
    }


    public long countFriendsPairings(int n) {
        long[] memo = new long[n+1];
        return countFriendsPairings_rec(n, memo);
    }
}
