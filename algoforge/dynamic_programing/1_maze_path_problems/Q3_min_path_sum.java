// https://leetcode.com/problems/minimum-path-sum/

public class Q3_min_path_sum {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        return minPathSum_helper(0,0,n,m,grid,dp);

    }

    public static int minPathSum_helper(int row, int col, int n, int m, int[][] grid, int[][] dp){

        if(row == n-1 && col == m-1){
            return dp[row][col] = grid[row][col];
        }

        int minCost = Integer.MAX_VALUE;

        if(dp[row][col]!=0){
            return dp[row][col];
        }

        // vertical
        if(row+1 < n){
            minCost = Math.min(minCost, minPathSum_helper(row+1,col,n,m, grid, dp));
        }
        // horizontal
        if(col+1 < m){
            minCost = Math.min(minCost, minPathSum_helper(row,col+1,n,m, grid, dp)); 
        }
        return dp[row][col] = minCost + grid[row][col];
    }

    public int minMazePathSum_tab(int n, int m, int[][] grid, int[][] dp){
        for(int row=n-1; row>=0; row--){
            for(int col=m-1; col>=0; col--){
                if(row == n-1 && col == m-1){
                    dp[row][col] = grid[row][col];
                    continue;
                }

                int minCost = Integer.MAX_VALUE;

                if(row+1 < n){
                    minCost = Math.min(minCost, dp[row+1][col]); //Math.min(minCost, minMazePathSum_rec(row+1,col,n,m,grid,dp));
                }

                if(col+1 < m){
                    minCost = Math.min(minCost, dp[row][col+1]); //Math.min(minCost, minMazePathSum_rec(row, col+1,n,m,grid,dp));
                }

                dp[row][col] = minCost + grid[row][col];
            }
        }

        return dp[0][0];
    }

    public int minMazePathSum_tab2(int n, int m, int[][] grid, int[][] dp,String[][] sdp){
        for(int row=n-1; row>=0; row--){
            for(int col=m-1; col>=0; col--){
                if(row == n-1 && col == m-1){
                    dp[row][col] = grid[row][col];
                    sdp[row][col] = grid[row][col] + "";
                } else if(row == n-1){
                    dp[row][col] = dp[row][col+1] + grid[row][col];
                    sdp[row][col] = grid[row][col] + "," + sdp[row][col+1];
                } else if(col ==  m-1){
                    dp[row][col] = dp[row+1][col] + grid[row][col];
                    sdp[row][col] =grid[row][col] + "," + sdp[row+1][col];
                } else {
                    if(dp[row+1][col] < dp[row][col+1]){
                        dp[row][col] = dp[row+1][col] + grid[row][col];
                        sdp[row][col] = grid[row][col] + "," + sdp[row+1][col];
                    } else {
                        dp[row][col] = dp[row][col+1] + grid[row][col];
                        sdp[row][col] = grid[row][col] + "," + sdp[row][col+1];
                    }
                }
            }
        }   

        System.out.println(sdp[0][0]);
        return dp[0][0];
    }
}
