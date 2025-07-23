// https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;

// what we'll do is, store the rotten oranges int a queue.
// now in level order bfs, we try to rot the neighbouring oranges.

public class Q3_rotten_oranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        LinkedList<Integer> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int freshOranges = 0;

        // added rotten oranges to a que.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                } else if(grid[i][j]==2){
                    que.add(i*m +j);
                }
            }
        }

        if(freshOranges == 0) return 0;
        
        int level = 0;  // no of levels is the time here..

        while(que.size()>0){
            int size = que.size();
            
            while(size-- > 0){
                int idx = que.removeFirst();

                int x = idx / m;
                int y = idx % m;

                for(int dir[] : dirs ){
                    int r = x+dir[0];
                    int c = y+dir[1];

                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                        freshOranges--;
                        // if(freshOranges==0) return level+1;
                        grid[r][c] = 2;
                        que.addLast( r*m + c);
                    }
                }
            }
            level++;
        }
        return freshOranges==0? level-1 : -1;

    }    
}
