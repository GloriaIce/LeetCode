/**
    Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

    Return the length of the longest (contiguous) subarray that contains only 1s. 

     

    Example 1:

    Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    Output: 6
    Explanation: 
    [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
    Example 2:

    Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    Output: 10
    Explanation: 
    [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int slow = 0;
        int count0 = 0;
        
        for (int fast = 0; fast < A.length; fast++) {
            if (A[fast] == 0) {
                count0++;
                if (count0 <= K) {
                    result = Math.max(result, (fast - slow + 1));
                } else {
                    result = Math.max(result, (fast - slow));
                    count0--;
                    slow = findNextZeroAfterX(A, slow) + 1;
                }
            } else if (fast == (A.length - 1)) {
                if ((fast - slow + 1) > result) {
                    result = fast - slow + 1;
                }
            }
        }
        
        return result;
    }

    private int findNextZeroAfterX(int[] A, int x) {
        for (int i = x; i < A.length; i++) {
            if (A[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}