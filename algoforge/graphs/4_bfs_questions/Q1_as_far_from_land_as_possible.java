// https://leetcode.com/problems/as-far-from-land-as-possible/

import java.util.*;

public class Q1_as_far_from_land_as_possible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        //inserting all land elements to iterate later. ( in 1d array )
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    que.addLast(i*m + j);
                }
            }
        }

        // if no land or water is there
        if(que.size()==0 || que.size()==n*m){
            return -1;
        }

        int level = 0;
        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                int idx = que.removeFirst();

                int x = idx/m;
                int y = idx%m;

                for(int[] dir: dirs){
                    int r = x+dir[0];
                    int c = y+dir[1];

                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==0){
                        grid[r][c] = 1;
                        que.addLast(r*m + c);
                    }
                }
            }
            level++;
        }
        return level-1;
    }
}
