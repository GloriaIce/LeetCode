class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int slow = 0;
        int product = 1;
        int result = 0;
        
        for (int fast = 0; fast < nums.length; fast++) {
            product = product * nums[fast];
            
            // find start of the window
            while (product >= k && slow <= fast) {
                product = product / nums[slow];
                slow++;
            }
            result += (fast - slow + 1);
        }
        return result;
    }
}