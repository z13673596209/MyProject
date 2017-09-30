package union_find;

/**
 * Created by DELL on 2017/8/24.
 * quick-find的union-find算法，存在N个触点时最坏情况下的花费为平方级别
 */
public class QuickFind extends UF {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

}
