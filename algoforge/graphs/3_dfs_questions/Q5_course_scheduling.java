// topological sort
// https://leetcode.com/problems/course-schedule/

import java.util.*;

// agar there is a loop/cycle in the path, then topological order cannot be formed
// so we check for cycle. if its not there, then we return true as it is.

// check cycle me what we are doingis, marking the visited as 1 for now.. and when that path is done/over, we mark them 2 in all. so that if there is any other path that points to this one, it doesnt treat it as a cycle dependent.
// so 1st path was 1,1,1,1... now as soon as it end, its all 2,2,2,2,2.
// now the new path starts with 1,1,1,1.. and it wont get mixed up with the prev. path.

public class Q5_course_scheduling {
     public boolean checkCycle(int src, ArrayList<Integer>[] graph, int[] vis){
        vis[src] = 1;

        for(int nbr: graph[src]){
            if(vis[nbr] == 1){
                return true;
            } else if(vis[nbr] == 0){
                if(checkCycle(nbr,graph, vis)) return true;
            }
        }

        vis[src] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: prerequisites){
            int u = edge[1];
            int v = edge[0];

            graph[u].add(v);
        }

        int[] vis = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(vis[i] == 0){
                if(checkCycle(i,graph,vis)) return false; // no possible topological order
            }
        }

        return true;
    }
}
