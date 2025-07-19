// need to check this again with dry run.

import java.util.*;

public class Q3_multisolver {
    static class Pair{
        int pathWeight;
        String path;

        public Pair(int pathWeight, String path){
            this.pathWeight = pathWeight;
            this.path = path;
        }
    }
    static String shortestPath = "";
    static int shortestPathWt = Integer.MAX_VALUE;
    static String longestPath = "";
    static int longestPathWt = Integer.MIN_VALUE;
    static String ceilPath = "";
    static int ceilPathWt = Integer.MAX_VALUE;
    static String floorPath = "";
    static int floorPathWt = Integer.MIN_VALUE;

    public static void traverseAllPath(int src, int des, String currPath, int currPathWt, boolean[] vis, ArrayList<Edge>[] graph, PriorityQueue<Pair> pq, int targetWt){

        if(src == des){
            if(currPathWt < shortestPathWt){
                shortestPathWt  = currPathWt;
                shortestPath = currPath;
            }
            if(currPathWt > longestPathWt){
                longestPathWt = currPathWt;
                longestPath = currPath;
            }
            // ceilPath
            if(currPathWt >= targetWt && currPathWt < ceilPathWt){
                ceilPathWt = currPathWt;
                ceilPath = currPath;
            }
            //floor
            if(currPathWt <= targetWt && currPathWt > floorPathWt){
                floorPathWt = currPathWt;
                floorPath = currPath;
            }

            pq.add(new Pair(currPathWt, currPath));
            if(pq.size() > k){
                pq.remove();
            }
        }

        vis[src] = true;
        for(Edge e: graph[src]){
            int nbr = e.v;
            int edgeWt = e.w;
            if(!vis[nbr]){
                traverseAllPath(nbr, des, currPath+nbr, currPathWt+edgeWt, vis, graph, pq, targetWt);
            }
        }
        vis[src]=false;

    }

    public static void multisolver(int src, int des, int k, int targetWt, ArrayList<Edge>[] graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b)->{
            return a.pathWeight - b.pathWeight;
        });

        traverseAllPath(src,des,""+src, 0, new boolean[graph.length], graph, pq, targetWt);

        System.out.println("Shortest Path is" + shortestPath + " with weight "+ shortestPathWt);
        System.out.println("longest Path is" + longestPath + " with weight "+ longestPathWt);
        System.out.println("Ceil Path is" + ceilPath + " with weight "+ ceilPathWt);
        System.out.println("Floor Path is" + floorPath + " with weight "+ floorPathWt);
        if(pq.size()>0){
            System.out.println("Kth longest path is " + pq.peek().path + " with weight "+ pq.peek().pathWeight);
        }
        
    }
}

