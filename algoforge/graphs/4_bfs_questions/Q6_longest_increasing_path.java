// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

// after kahns algo.

import java.util.LinkedList;

public class Q6_longest_increasing_path {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int[][] indegree = new int[n][m];

        // sabse pehle calculate indegree
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int[] dir: dirs){   // 0(4)
                    
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x>=0 && y>=0 && x<n && y<m && matrix[i][j]>matrix[x][y]){
                        indegree[i][j]++;
                    }
                }
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        // fir bfs laga do

        //adding 0 indegree wale to que/
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(indegree[i][j]==0){
                    que.addLast(i*m + j);
                }
            }
        }

        int level = 1;
        while(que.size()>0){
            int size = que.size();

            while(size-- > 0){
                int idx = que.removeFirst();

                int x = idx/m;
                int y = idx%m;

                for(int[] dir: dirs){
                    int r = x+ dir[0];
                    int c = y+dir[1];

                    // agar neighbour me koi badi value rakhi h, to uski indegree ko kam kar dena hai..
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c] > matrix[x][y]){
                        indegree[r][c]--;
                        if(indegree[r][c] == 0){
                            que.addLast(r*m + c);
                        }
                    }
                }
            }
            level++;
        }
        return level -1;
    }
}
