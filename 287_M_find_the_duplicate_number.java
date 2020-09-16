class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        int lastSeen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == lastSeen) {
                return nums[i];
            } else {
                lastSeen = nums[i];
            }
        }
        return 0;
    }
}