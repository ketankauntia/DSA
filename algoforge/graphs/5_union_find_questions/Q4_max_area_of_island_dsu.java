// https://leetcode.com/problems/max-area-of-island/

import java.util.*;
public class Q4_max_area_of_island_dsu {

    int[] par;
    int[] size;
    public int findPar(int u){
        if(par[u] == u){
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        par = new int[n*m];
        size = new int[n*m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){ // initially, an island of one size
                    par[i*m + j] = i*m + j;
                    size[i*m + j] = 1;
                } else { // not an island
                    par[i*m + j] = -1;
                    size[i*m + j] = 0;
                }
            }
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int p1 = findPar(i*m + j);
                    for(int[] dir: dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == 1){
                            int p2 = findPar(x*m + y);
                            // merge(p1,p2);
                            if(p1 != p2){
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }   
                        }
                    }
                }
            }
        }

        int max_area = 0;
        for(int i=0; i<n*m; i++){
            if(par[i] == i){
                max_area = Math.max(max_area, size[i]);
            }
        }

        return max_area;
    }
}
