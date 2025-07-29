// https://leetcode.com/problems/min-cost-to-connect-all-points/

import java.util.*;
public class Q1_min_cost_Connect_all_points {

    public int findCost(int[] x, int[] y){
        return Math.abs(x[0] - y[0]) + Math.abs(x[1]-y[1]);
    }

    public int[][] createEdges(int[][] points){
        int n = points.length;
        int totalEdges = n*(n-1)/2;

        int[][] edges = new int[totalEdges][3];
        int idx = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1; j<n;j++){
                int u = i;
                int v = j;
                int w = findCost(points[i], points[j]);

                edges[idx][0] = u;
                edges[idx][1] = v;
                edges[idx][2] = w;
                
                idx++;
            }
        }
        return edges;
    }

    // kruskal pura same yaha se almost ------------
    static int[] par;
    static int[] size;

    public int findPar(int u){
        if(par[u]==u){
            return u;
        }
        return par[u] = findPar(par[u]);
    }

    public void merge(int p1, int p2){
        if(par[p1]>par[p2]){
            par[p2] = p1;
            size[p1] += size[p2];
        } else{
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }

    public int find_mst_kruskal(int n, int[][] edges){
        int totalCost = 0;
        par = new int[n];
        size = new int[n];

        for(int i=0; i<n;i++){
            par[i]=i;
            size[i] = 1;
        }

        // sorting in asc. order wrt weight
        Arrays.sort(edges,(int[] a, int[] b)->{
            return a[2]-b[2];
        });

        for(int[] edge: edges){
            int u = edge[0];
            int v= edge[1];
            int w = edge[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1, p2);
                totalCost += w;
            }
        }
        return totalCost;
    }


    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;

        int[][] edges = createEdges(points);

        return find_mst_kruskal(n,edges);

    }    
}
