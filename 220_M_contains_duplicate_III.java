/**
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the absolute difference between nums[i] and nums[j] is at most 
 * t and the absolute difference between i and j is at most k.
 * Example 1:

 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:

 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:

 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 
*/

/* O(n^2) - Time Limit Exceeded */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < Math.min(nums.length, i + k + 1); j++) {
                if (Math.abs(1L * nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
            
        }
        return false;
    }
}

/* TreeSet O(nlog(k))*/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int length = 0;
        
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling(1L * nums[i] - t);
            Long floor = set.floor(1L * nums[i] + t);
            if ((floor != null && floor >= nums[i]) || 
                    (ceiling != null && ceiling <= nums[i])) {
                return true;
            } else {
                set.add(1L * nums[i]);
                length++;
                
                if (length > k) {
                    set.remove(1L * nums[i - k]);
                }
            }
        }
        
        return false;
    }
}