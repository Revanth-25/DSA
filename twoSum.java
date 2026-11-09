//Two Sum - LeetCode

// You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: The sum of nums[0] and nums[1] is 2 + 7 = 9, which equals the target. Therefore, the indices [0, 1] are returned.

//We can also use to pointers on a sorted array just to return true/ false if a value is present or not

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // for(int i=0 ; i<n; i++){
        //     for(int j=0;j<n; j++){
        //         if(i==j) continue;
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return null;

        Map<Integer,Integer> list = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            int req = target -  nums[i];
            if(list.containsKey(req)){
                return new int[]{i,list.get(req)};
            }
            list.put(nums[i],i);
        }
        return new int[]{};
    }
}