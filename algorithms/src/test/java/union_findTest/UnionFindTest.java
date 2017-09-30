package union_findTest;

import union_find.QuickFind;
import union_find.QuickUnion;
import union_find.UF;
import union_find.WeightingQuickUnion;

/**
 * Created by DELL on 2017/8/24.
 * 用来测试三种算法的时间消耗
 */
public class UnionFindTest {
    public static void main(String[] args) {
        int N = 100000;//模拟触点数量
        UF quickFind = new QuickFind(N);
        UF quickUnion = new QuickUnion(N);
        UF weightingQuickUnion = new WeightingQuickUnion(N);
        int Q = 100000;//模拟连接数量
        System.out.println("触点数目：" + N + ";连接数目：" + Q);
        System.out.println("开始测试QuickFind算法所花费时间");
        Union_FindSimulation union_findSimulation = new Union_FindSimulation(quickFind, Q);
        union_findSimulation.wasteTime();
        System.out.println("开始测试QuickUnion算法所花费时间");
        union_findSimulation = new Union_FindSimulation(quickUnion, Q);
        union_findSimulation.wasteTime();
        System.out.println("开始测试WeightingQuickUnion算法所花费时间");
        union_findSimulation = new Union_FindSimulation(weightingQuickUnion, Q);
        union_findSimulation.wasteTime();
    }
}
