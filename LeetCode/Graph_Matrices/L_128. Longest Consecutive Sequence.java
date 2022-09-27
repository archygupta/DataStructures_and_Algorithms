/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

class Solution {
    public int longestConsecutive(int[] nums) {
      HashSet<Integer> hs = new HashSet<Integer>();
      for(int n:nums){
        hs.add(n);
      }
      
      int longestStreak=0;
      for(int n:hs){
        if(!hs.contains(n-1)){
          int currNum = n;
          int currStreak = 1;
          while(hs.contains(currNum+1)){
            currNum=currNum+1;
            currStreak = currStreak+1;
          }
          longestStreak=Math.max(longestStreak, currStreak);
        }
      }
  return longestStreak;
}
}
