package leetcode.Array.Easy;
//去除数组中重复的元素并返回不重复数组的长度
public class RemoveDuplicatesFromSortedArray {

        public int removeDuplicates(int[] nums) {
            if(nums.length==0)return 0;
            int a=nums[0];
            int t=1;
            for(int i = 1;i<nums.length;i++){
                if( a != nums[i]){
                    a=nums[i];
                    nums[t++]=nums[i];

                }
            }
            return t;

        }
}
