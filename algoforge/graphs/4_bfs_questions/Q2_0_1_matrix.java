// https://leetcode.com/problems/01-matrix/

import java.util.LinkedList;

public class Q2_0_1_matrix {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        //adding all zero's
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    que.addLast(i*m + j);
                }
            }
        }

        int[][] res = new int[n][m];

        int level = 0;
        while(que.size()>0){
            int size = que.size();

            while(size-- > 0){
                int idx = que.removeFirst();

                int x = idx/m;
                int y = idx%m;

                for(int[] dir: dirs){
                    int r= x+dir[0];
                    int c = y+dir[1];

                    if(r>=0 && c>=0 && r<n && c<m && mat[r][c]==1){
                        mat[r][c] = 0;
                        res[r][c] = level + 1;
                        que.addLast(r*m + c);
                    }
                }
            }
            level++;
        }
        return res;
    }
}
