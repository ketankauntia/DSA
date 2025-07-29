// https://leetcode.ca/all/1168.html


// what we will do is, use mst, but, there is this option to dig wells as well.
// what if we can convert this digging of wells as an edge, which naturally translates the cost of digging path into an option.
// now once we have all the pipes ka cost and digging well's ka cost, sort them and kruskals..

//  refered video : https://www.youtube.com/watch?v=gc6ShDTldb4

import java.util.*;
public class Q2_optimize_water_distribution {

    static int[] par;
    static int[] size;

    public int findPar(int u){
        if(par[u]==u){
            return u;
        }
        return par[u]=findPar(par[u]);
    }

    public void merge(int p1, int p2){
        if(size[p1]>size[p2]){
            par[p2] = p1;
            size[p1] += size[p2];
        } else{
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }

    // n = no. of houses
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        int newEdgesLength = pipes.length + n;
        int [][] edges = new int[newEdgesLength][3];

        
        // making new edges for digging wells
        int idx = 0;
        for(int i=0; i<n;i++){
            edges[idx][0] = 0;
            edges[idx][1] = i+1;
            edges[idx][2] = wells[i];
            
            idx++;
        }
        
        // adding pipes ka length to edges where we stored digging wala edges
        for(int[] pipe : pipes){
            edges[idx][0] = pipe[0];
            edges[idx][1] = pipe[1];
            edges[idx][2] = pipe[2];
            
            idx++;
        }
        
        // imp : we are working with n houses (1-indexed from 1 to n), and we have added a virtual node 0 for modeling wells into edges.. so..
        // and we need the size wrt no of node and not no. of edges. [ IMP ]
        par = new int[n + 1];   
        size = new int[n + 1];

        for(int i = 0; i <= n; i++){
            par[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges,(int[] a, int[] b)->{
            return a[2] - b[2]; 
        });

        int cost = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1, p2);
                cost += w;
            }
        }
        return cost;
    
    }
}


//  solved on : https://www.naukri.com/code360/problems/water-supply-in-a-village_1380956?leftPanelTabValue=SUBMISSION

import java.util.Arrays;

public class Solution {

    static int[] par;
    static int[] size;

    public static int findPar(int u){
        if(par[u]==u){
            return u;
        }
        return par[u]=findPar(par[u]);
    }

    public static void merge(int p1, int p2){
        if(size[p1]>size[p2]){
            par[p2] = p1;
            size[p1] += size[p2];
        } else{
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }

    // n = no. of houses
    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
        
        int newEdgesLength = pipes.length + n;
        int [][] edges = new int[newEdgesLength][3];

        
        // making new edges for digging wells
        int idx = 0;
        for(int i=0; i<n;i++){
            edges[idx][0] = 0;
            edges[idx][1] = i+1;
            edges[idx][2] = wells[i];
            
            idx++;
        }
        
        // adding pipes ka length to edges where we stored digging wala edges
        for(int[] pipe : pipes){
            edges[idx][0] = pipe[0];
            edges[idx][1] = pipe[1];
            edges[idx][2] = pipe[2];
            
            idx++;
        }
        
        // imp : we are working with n houses (1-indexed from 1 to n), and we have added a virtual node 0 for modeling wells into edges.. so..
        // and we need the size wrt no of node and not no. of edges. [ IMP ]
        par = new int[n + 1];   
        size = new int[n + 1];

        for(int i = 0; i <= n; i++){
            par[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges,(int[] a, int[] b)->{
            return a[2] - b[2]; 
        });

        int cost = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1, p2);
                cost += w;
            }
        }
        return cost;
    
    }
}