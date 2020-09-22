/**
    Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

    Example 1:
    Input: [1,0,1,1,0]
    Output: 4
    Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
        After flipping, the maximum number of consecutive 1s is 4.
    Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
    Follow up:
    What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers 
    coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int result = 1;
        int lastZeroPosision = -1;
        int slow = 0;
        
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                if (lastZeroPosision == -1) {
                    lastZeroPosision = fast;
                    result = fast - slow + 1;
                } else {
                    if ((fast - slow) > result) {
                        result = fast - slow;
                    }
                    slow = lastZeroPosision + 1;
                    lastZeroPosision = fast;
                }
            } else if (fast == (nums.length - 1)) {
                if ((fast - slow + 1) > result) {
                    result = fast - slow + 1;
                }
            }
        }
        
        return result;
    }
}