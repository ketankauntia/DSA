// https://leetcode.com/problems/possible-bipartition/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q8_possible_bipartition {
    public boolean isCycleEven(ArrayList<Integer>[] graph, int src, int[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        int color = 0; // even level, color = 0, odd level, color = 1
        
        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                int vtx = que.removeFirst();

                if(vis[vtx] != -1 && vis[vtx] != color){ // already but not equal to current level
                    return false; // odd cycle
                }

                vis[vtx] = color;

                for(int nbr: graph[vtx]){
                    if(vis[nbr] == -1){
                        que.addLast(nbr);
                    }
                }
            }
            color = (color + 1) % 2; // color = 0->1, 1->0
        }

        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: dislikes){
            int u = edge[0] - 1; // vertices are from 1,n -> changing them to 0,n
            int v = edge[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1); // not visited = -1

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                if(isCycleEven(graph,i,vis) == false){
                    return false;
                }
            }
        }

        return true;
    }
}
}
