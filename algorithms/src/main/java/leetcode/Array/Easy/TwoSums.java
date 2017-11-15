package leetcode.Array.Easy;

import java.util.HashMap;
import java.util.Map;
/*
* 数组中两个数相加等于指定值，找出这两个数的下标
* */
public class TwoSums {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> result = new HashMap<>();
            for(int i = 0;i<nums.length;i++){
                int solution = target - nums[i];
                if(result.containsKey(solution)){
                    return new int[]{result.get(solution),i};
                }
                result.put(nums[i],i);
            }
            throw new IllegalArgumentException("now solution");
        }
    }

