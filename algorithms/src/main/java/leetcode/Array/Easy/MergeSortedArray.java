package leetcode.Array.Easy;
/*
* 合并两个有序数组
* */
public class MergeSortedArray {
        public void merge(int A[], int m, int B[], int n) {
            int i=m-1, j=n-1, k=m+n-1;
            while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
            while (j>-1)         A[k--]=B[j--];
        }
}
