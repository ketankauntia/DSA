// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.LinkedList;

public class Q4_shortest_path_in_binary_matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        LinkedList<Integer> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};

        if(grid[0][0] == 0){
            que.addLast(0);
            grid[0][0] = 1;
        }

        int dis = 1;

        while(que.size() > 0){
            int size = que.size();
            
            while(size-- > 0){
                int idx = que.removeFirst();
                int i = idx/m;
                int j = idx%m;

                if(i==n-1 && j==m-1) return dis;

                for(int[] dir: dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == 0){
                        if(x == n-1 && y == m-1) return dis + 1;

                        grid[x][y] = 1;
                        que.addLast(x*m + y);
                    }
                }
            }
            dis++;
        }

        return -1;
    }
}
