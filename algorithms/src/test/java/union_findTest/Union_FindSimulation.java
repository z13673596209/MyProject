package union_findTest;

import algorithm_analysis.StopWatch;
import union_find.UF;

/**
 * Created by DELL on 2017/8/24.
 * 模拟触点和连接并测试Union-Find运行花费的时间
 */
public class Union_FindSimulation {
    private UF uf;
    private int Q;//连接数量
    private int N;//触点数量
    public Union_FindSimulation(UF uf, int Q) {
        this.uf = uf;
        this.Q = Q;
        this.N = uf.count();

    }
    public void wasteTime() {
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < Q; i++) {
            int p = (int) (Math.random() * N);
            int q = (int) (Math.random() * N);//模拟对应的连接
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
//            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
        System.out.println("花费时间为" + stopWatch.elapsedTime() + "秒");
    }
}
