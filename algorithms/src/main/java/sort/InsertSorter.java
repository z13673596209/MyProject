package sort;

public class InsertSorter {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            Comparable temp = a[i];
            //逐个判断索引之前的数跟索引所在位置数的大小，判断需要插入的位置，就插入
            while (j >= 0 && EasySorter.less(temp, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            if (j != i - 1) {
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a= new Integer[] {5,9,2,1,6,3};
        sort(a);
        System.out.println("插入排序：");
        EasySorter.show(a);
    }
}


