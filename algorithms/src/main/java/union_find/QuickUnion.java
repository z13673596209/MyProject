package union_find;

/**
 * Created by DELL on 2017/8/24.
 */
public class QuickUnion extends UF{

    public QuickUnion(int N){
        super(N);
    }

    @Override
    public int find(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p,int q){
     int pRoot = find(p);
     int qRoot = find(q);
     if(pRoot == qRoot) return;
     id[pRoot] = qRoot;
     count--;
    }
}
