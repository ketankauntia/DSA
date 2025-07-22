// https://leetcode.com/problems/find-eventual-safe-states/

import java.util.*;

// loop lagaya, visiting each node. agar visited nai h, to we visit by calling dfs
// jaise hi we visit we mark them 1. and when we return, postfix me we make it 2.
// if there is a cycle, it marks it as true, and return true, so it stays 1 only..
// finally we know whichever nodes are marked 2, are safe nodes.

public class Q7_eventual_safe_states {

    public boolean dfs(int src, int[][] graph, int[] vis){
        vis[src] = 1;

        for(int nbr: graph[src]){
            if(vis[nbr] == 1){
                return true;
            }else if(vis[nbr]==0){
                if(dfs(nbr,graph,vis) == true){
                    return true;
                }
            }
        }
        vis[src]=2;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,graph, vis);
            }
        }

        List<Integer> safeStates = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==2){
                safeStates.add(i);
            }
        }
        return safeStates;
    }
}
