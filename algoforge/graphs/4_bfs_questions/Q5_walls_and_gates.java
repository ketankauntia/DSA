// https://www.lintcode.com/problem/663/

import java.util.LinkedList;

public class Q5_walls_and_gates {
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;

        LinkedList<Integer> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]== inf){
                    que.addLast(i*m + j);
                }
            }
        }

        int level = 0;
        while(que.size()>0){
            int size = que.size();

            while (size-- > 0) {
                int idx = que.removeFirst();

                int x = idx/m;
                int y = idx%m;

                for(int[] dir: dirs){
                    int r = x+dir[0];
                    int c = y+dir[1];

                    if(r>=0 && c>=0 && r<n && c<m && rooms[r][c]==inf){
                        que.addLast(r*m + c);
                        rooms[x][y] = level+1;
                    }
                }
            }
            level++;
        }
    }
}
