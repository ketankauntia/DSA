// https://leetcode.com/problems/course-schedule-ii/description/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Q6_course_schedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        ArrayList<Integer> order = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            int u = edge[1];
            int v= edge[0];

            graph[u].add(v);
        }

        int vis[] = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(vis[i]==0){
                if(topo_dfs(i,graph,vis,order)){
                    return new int[]{};
                }
            }
        }
        Collections.reverse(order);
        int[] ansArray = order.stream().mapToInt(Integer::intValue).toArray(); // converting arraylist to array

        return ansArray;
    }

    public boolean topo_dfs(int src, ArrayList<Integer>[] graph, int[] vis, ArrayList<Integer> order){
        vis[src] = 1;

        for(int nbr: graph[src]){
            if(vis[nbr] == 1){
                return true;
            } else if(vis[nbr] == 0){
                if(topo_dfs(nbr,graph, vis, order)) return true;
            }
        }

        vis[src] = 2;
        order.add(src);
        return false;
    }
}
