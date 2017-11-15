package MapMST;

import bag_queue_stack.ArrayBag;
/*
* 代表加权无向图中的图
* */
public class EdgeWeightedGraph {
    private final int V;//顶点总数
    private int E;//边的总数
    private ArrayBag<Edge>[] adj; //顶点数组及其邻接表

    public EdgeWeightedGraph(int V){
        this.V  = V;
        this.E = 0;
        adj = (ArrayBag<Edge>[])new ArrayBag[V];
        for (int v=0;v<V;v++){
            adj[v] = new ArrayBag<Edge>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    //添加一条边
    public void addEdge(Edge e){
        int v=e.either(),w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    //获取某一点相连的边
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
}
