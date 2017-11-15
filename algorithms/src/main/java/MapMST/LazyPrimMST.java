package MapMST;

import bag_queue_stack.LinkQueue;

public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点
    private LinkQueue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new LinkQueue<Edge>();
        visit(G,0);
        while (!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either(),w=e.other(v);
            if(marked[v]&&marked[w]) continue;//跳过失效的边
            mst.enqueue(e);//将边添加到树中
            if(!marked[v]) visit(G,v);//将顶点添加到树中
            if(!marked[w]) visit(G,w);
        }

    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if(!marked[e.other(v)]){
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
