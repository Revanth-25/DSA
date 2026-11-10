// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        int maxLen = 0;

        //Brute Force (O(n2))
        // for(int i=0; i<n ;i++){
        //     int [] hash = new int [256];
        //     for(int j=i; j<n; j++){
        //         if(hash[s.charAt(j)]==1) break;
        //         len = j - i + 1;
        //         maxLen = Math.max(len,maxLen);
        //         hash[s.charAt(j)]=1;
        //     }
        // }
        // return maxLen;

        //Optimal -> Sliding Window and Two Pointer
        int l = 0;
        int r = 0;
        int [] hash = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = -1;
        }

        while(r<n){
            if(hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
            }
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}


//For every character we are checking is character is within the window
//and it appered or not and updating l, r pointers accordingly 
//and calculating length and updating maxLength
