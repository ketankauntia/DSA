// https://leetcode.com/problems/island-perimeter/


public class Q4_island_perimeter {

    // A grid of 1 can atmax contribute 4 as perimter coz of 4 sides.
    // if there is a neighbour on either side, we need to decrease that shit
    // now, what if we calculate teh no of neighbours of each grid.
    // and subtract it from max neighbours/perimeter the grids can max?
    // ez ans.

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int oneCount = 0;   // no of 1's present
        int nbrCount = 0;   // no of neighbours for each 1's

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    oneCount++;

                    for(int[] dir : directions){
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                            nbrCount++;
                        }
                    }
                }
            }
        }
        return 4*oneCount - nbrCount;
    }
}
