// https://leetcode.com/problems/number-of-islands/description/

public class Q1_no_of_islands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // if island is not visited & it is an island
                if(!vis[i][j] && grid[i][j]=='1'){
                    visitIsland(i,j,n,m,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void visitIsland(int r, int c, int n, int m, char[][] grid, boolean[][] vis){

        vis[r][c] = true;

        int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};    // directions array
        // top right bottom left

        for(int[] dir: dirs){
            int x = r+dir[0];
            int y = c+dir[1];

            // shoudl be within grid limits & islands logic.
            if(x>=0 && y>=0 && x<n && y<m && !vis[x][y] && grid[x][y]=='1'){
                visitIsland(x, y, n, m, grid, vis);
            }
        }
    }
}
