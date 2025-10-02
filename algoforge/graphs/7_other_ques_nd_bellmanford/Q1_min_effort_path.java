// https://leetcode.com/problems/path-with-minimum-effort/

import java.util.Arrays;
import java.util.PriorityQueue;

class Q1_min_effort_path{

    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        // cell position, max abs diff so far
        PriorityQueue<int []> pq = new PriorityQueue<>((int[] a, int[] b)->{
            return a[1]-b[1];
        });
        
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int [][] dis = new int [n][m];

        for(int[] d : dis){
            Arrays.fill(d, (int)(1e8));
        }

        pq.add(new int[]{0,0});
        dis[0][0] = 0;

        while(pq.size() > 0){
            int[] top = pq.remove();
            int i = top[0]/m;
            int j = top[0]%m;

            int maxWeightSoFar = top[1];

            if(dis[i][j] < maxWeightSoFar) continue;

            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];

                if(x>=0 && x<n && y>=0 && y<m){
                    int currentWeight = Math.abs(heights[i][j] - heights[x][y]);

                    if(dis[x][y] > Math.max(maxWeightSoFar, currentWeight)){
                        dis[x][y] = Math.max(maxWeightSoFar, currentWeight);
                        pq.add(new int[]{x*m + y, dis[x][y]});
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}

//  video left at 01:19:00 -----------------
// more questions and bellman ford