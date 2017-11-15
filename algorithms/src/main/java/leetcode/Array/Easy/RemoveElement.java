package leetcode.Array.Easy;
//移除数组中给定的数字
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}
