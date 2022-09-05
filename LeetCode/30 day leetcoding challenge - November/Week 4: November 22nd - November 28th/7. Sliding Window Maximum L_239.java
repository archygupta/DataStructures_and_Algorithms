https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,-1], k = 1
Output: [1,-1]

Example 4:
Input: nums = [9,11], k = 2
Output: [11]

Example 5:
Input: nums = [4,-2], k = 2
Output: [4]
 
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

Hint #1  
How about using a data structure such as deque (double-ended queue)?
Hint #2  
The queue size need not be the same as the window’s size.
Hint #3  
Remove redundant elements and the queue should store only elements that need to be considered.
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        int[] res = new int[nums.length-k+1];
        int idx=0;
        for(int i=0;i<nums.length;i++){
          //remove outside window indexes
          if(!q.isEmpty() && q.getFirst()<i-k+1){
            q.removeFirst();
          }
          
          //remove less value indexes than current
          while(!q.isEmpty() && nums[q.getLast()]<nums[i]){
            q.removeLast();
          }
          
          //add current to queue
          q.add(i);
          
          //add to result, if current window size is k
          if(i>=k-1){
            res[idx++]=nums[q.getFirst()];
          }
        }
      return res;
    }
}
