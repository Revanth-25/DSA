//Given an integer array nums, find the subarray with the largest sum, and return its sum.
// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        //Brute force O(n3)
        int sum = 0;
        // for(int i=0;i<n;i++){
        //     for (int j=i;j<n;j++){
        //         sum = 0;
        //         for(int k=i;k<=j;k++){
        //             sum += nums[k];
        //             max = Math.max(sum,max);
        //         }
        //     }
        // }
        //Better Approch O(n2) - Still fails Time Limit
        // for(int i=0;i<n;i++){
        //     sum = 0;
        //     for (int j=i;j<n;j++){
        //             sum += nums[j];
        //             max = Math.max(sum,max);
        //     }
        // }
        // return max;
        //Kadane's algorithm - O(n)
        for(int i=0 ; i<n ; i++){
            sum = sum + nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}