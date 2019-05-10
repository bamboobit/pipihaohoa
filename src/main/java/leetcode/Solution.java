package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xfh
 * @Date: 2019/5/10
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    /*
    * time O(n^2)
    * space O(1)
    * */
    private static int[] twoSum1(int[] nums, int target) {
        for(int i=0,len=nums.length;i<len-1;i++){
            int left = target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==left){
                    return new int[]{i,j};
                }else {
                    continue;
                }
            }
        }
        throw new IllegalArgumentException("no such result");
    }

    /*
     * time O(n)
     * space O(n)
     * */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap();
        int len = nums.length;
        for(int i=0;i<len;i++){
            map.put(nums[i],i);
        }
        for(int j=0;j<len;j++){
            int left= target-nums[j];
            if(map.containsKey(left) && map.get(left)!=j){
                return new int[] {j,map.get(left)};
            }
        }
        throw new IllegalArgumentException("no such result");
    }
    public static void main(String[] args) {
        int[] nums={3,3,6};
        int target=7;
        int[] result=twoSum2(nums,target);
        System.out.println(result[0]+" and "+result[1]);
    }
}
