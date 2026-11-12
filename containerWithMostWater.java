
// 11. Container With Most Water
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxStorage = 0;
        //Brute force ( TLE - o(N2)) 
        // for(int i=0 ; i<n ;i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         int w = j - i;
        //         int h = Math.min(height[i], height[j]);
        //         int storage = w * h;
        //         maxStorage = Math.max(storage, maxStorage);
        //     }
        // }
        // return maxStorage;

        //Two Pointer Approach (O(n))
        int lp = 0;
        int rp = n-1;
        while(lp<rp){
            int w = rp - lp;
            int h = Math.min(height[lp], height[rp]);
            int storage = w * h;
            maxStorage = Math.max(storage, maxStorage);

            if(height[lp] < height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxStorage;
    }
}