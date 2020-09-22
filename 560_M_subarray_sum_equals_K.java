/**
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:

    Input:nums = [1,1,1], k = 2
    Output: 2

    [1,3,0,-3,3,2,5,7] 4
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        if (sums[0] == k) {
            result++;
        }

        for (int i = 1; i < nums.length; i++) {
             sums[i] = sums[i - 1] + nums[i];
             if (sums[i] == k) {
                result++;
             }
             for (int j = 0; j < i; j++) {
                if ((sums[i] - sums[j]) == k) {
                    result++;
                }
             }
        }
        return result;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (frequencyMap.containsKey(sum - k)) {
                result += frequencyMap.get(sum - k);
             }

             if (frequencyMap.containsKey(sum)) {
                frequencyMap.replace(sum, frequencyMap.get(sum) + 1);
             } else {
                frequencyMap.put(sum, 1);
             }
        }
        return result;
    }
}