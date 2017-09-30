package union_find;

import java.util.Random;

/**
 * Created by DELL on 2017/8/24.
 */
public abstract  class UF {
    protected int[] id;//分量id
    protected int count;//分量数量
    public UF(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
    }
    public  int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }
    public abstract int find(int p);
    public abstract void union(int p ,int q);
}
