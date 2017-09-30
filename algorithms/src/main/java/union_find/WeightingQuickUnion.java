package union_find;

/**
 * Created by DELL on 2017/8/24.
 */
public class WeightingQuickUnion extends UF {
    private int[] sz;//各个根节点对应的分量大小

    public WeightingQuickUnion(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];//路径压缩，在遍历的同时将子节点的父节点设置为其爷爷节点
            p = id[p];

        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        //将小树的根节点链接到大树上面
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] = sz[pRoot] + sz[qRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
}
