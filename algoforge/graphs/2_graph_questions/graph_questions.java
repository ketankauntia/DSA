import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w){
        this.u = u;     // starting point
        this.v = v;     // ending point
        this.w = w;     // weight
    }

    @Override 
    public String toString(){
        return "{" + this.u + " -> " + this.v + ": " + this.w + "}";
    }

    // 42:29 ------------------------------
}


public class graph_questions {
    
    // add edge util =====================================
    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    // display graph =====================================
    public static void displayGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            System.out.print("Edges on vertex "+i+" -> ");
            for(Edge e: graph[i]){
                System.out.print(e+",");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int N = 8;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];

        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph,0,1,10);
        addEdge(graph,1,2,11);
        addEdge(graph,1,3,7);
        // addEdge(graph,1,4,12);
        addEdge(graph,2,4,9);
        // addEdge(graph,2,5,3);
        addEdge(graph,5,6,6);
        addEdge(graph,5,7,5);
        addEdge(graph,6,7,4);

        // displayGraph(graph);
        System.out.println(hasPath(0,7,graph,N));
    } 
}