// https://leetcode.com/problems/max-area-of-island/description/

public class Q3_area_of_islands {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int currentArea = visitAndCount(i,j,n,m,grid);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }
    public int visitAndCount(int r,int c, int n, int m, int[][] grid){
        
        grid[r][c] = 0;
        int count = 0;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir: directions){
            
            int x = r+dir[0];
            int y = c+dir[1];

            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                count += visitAndCount(x, y, n, m, grid);
            }
        }
        return count+1;
    }
}