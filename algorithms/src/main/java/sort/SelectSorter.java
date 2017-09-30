package sort;

public class SelectSorter implements EasySorter {

    public static void sort(Comparable[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            for(int t = i+1;t<a.length;t++){
                if(EasySorter.less(a[t],a[i])){ //逐个判断索引i之后的元素是否小于索引i，如果小于将其置于索引处
                    EasySorter.exch(a,t,i);
                }
            }

        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3,1,8,10,6};
        sort(a);
        System.out.println("选择排序：");
        EasySorter.show(a);

    }
}
