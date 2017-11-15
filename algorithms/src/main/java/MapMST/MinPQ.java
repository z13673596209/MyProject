package MapMST;

import java.util.Arrays;

public class MinPQ<Edge> {
    private Edge[] pq;
    private int length = 0;
    public Edge delMin(){
        Arrays.sort(pq);
        Edge edge = pq[0];
        Edge[] newPq = (Edge[]) new Object[--length];
        for(int i =0;i<newPq.length;i++){
            newPq[i] = pq[i+1];
        }
        pq = newPq;
      return edge;
    }
    public boolean isEmpty(){
        if(length==0){
            return true;
        }else{
            return false;
        }
    }
    public void insert(Edge e){
        Edge[] newPq =  (Edge[])new Object[++length];
        for(int i =0;i<pq.length;i++){
            newPq[i] = pq[i];
        }
        newPq[newPq.length] = e;
        pq = newPq;
    }
}
