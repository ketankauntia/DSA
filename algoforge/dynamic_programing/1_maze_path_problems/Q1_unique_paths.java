// https://leetcode.com/problems/unique-paths/

public class Q1_unique_paths {


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        return uniquePaths_helper(0,0,m,n,dp);
    }

    public int uniquePaths_helper(int r, int c, int n, int m, int[][] dp){
        if(r == n-1 && c == m-1){
            return dp[r][c] = 1;
        }

        if(dp[r][c] != 0){
            return dp[r][c];
        }

        int totalpaths = 0;

        if(r+1 < n){
            totalpaths += uniquePaths_helper(r+1,c,n,m,dp);
        }

        if(c+1 < m){
            totalpaths += uniquePaths_helper(r,c+1,n,m,dp);
        }
        // if(r+1 < n && c+1 < m){
        //     totalpaths += uniquePaths_helper(r+1,c+1,n,m,dp);
        // }

        return dp[r][c] = totalpaths;
    }

    public static int totalMazePaths_tab(int n, int m, int[][] dp){
        for(int row = n-1; row>=0; row--){
            for(int col = m-1; col>=0; col--){
                if(row == n-1 && col == m-1){
                    dp[row][col] = 1;
                    continue;
                }

                int totalpaths = 0;

                if(row+1 < n){
                    totalpaths += dp[row+1][col];
                }

                if(col+1 < m){
                    totalpaths += dp[row][col+1];
                }
                // if(r+1 < n && c+1 < m){
                //     totalpaths += uniquePaths_helper(r+1,c+1,n,m,dp);
                // }

                dp[row][col] = totalpaths;
            }
        }
        return dp[0][0];
    }
}

