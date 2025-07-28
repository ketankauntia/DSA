// https://leetcode.com/problems/number-of-provinces/

public class Q3_no_of_provinces {
    static int[] par;
    static int[] size;

    public int findPar(int u){
        if(par[u]==u){
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public void merge(int p1, int p2){
        if(size[p1]>size[p2]){
            par[p2] = p1;
            size[p2] += size[p1];
        } else{
            par[p1] = p2;
            size[p1] += size[p2];
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if(p1 != p2){
                        merge(p1, p2);
                    }
                }
            }
        }

        int total_comps = 0;
        for(int i=0;i<n;i++){
            if(par[i] == i){    // unqiue leader
                total_comps++;
            }
        }
        return total_comps;
    }
}


// ============================ method 2,

public class Q3_no_of_provinces_method2 {
    static int[] par;
    static int[] size;

    public int findPar(int u){
        if(par[u]==u){
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public void merge(int p1, int p2){
        if(size[p1]>size[p2]){
            par[p2] = p1;
            size[p2] += size[p1];
        } else{
            par[p1] = p2;
            size[p1] += size[p2];
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }

        int total_comps = n;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if(p1 != p2){
                        merge(p1, p2);
                        total_comps--;
                    }
                }
            }
        }

        
        return total_comps;
    }
}
