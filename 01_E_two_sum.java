/* Solution 1 Hashmap*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<value, index>
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
}

/* Two pointers on sorted array see problem 167 - two sum 2 */