class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closestSum);

        for(int i = 0; i < nums.length - 2; i++) {
            int closestSumOfTwo = twoSum(nums, target - nums[i], i + 1);
            if (Math.abs(target - closestSumOfTwo - nums[i]) < diff) {
                closestSum = nums[i] + closestSumOfTwo;
                diff = Math.abs(target - closestSumOfTwo - nums[i]);
            }
        }

        return closestSum;
    }
    
    private int twoSum(int[] nums, int target, int beginning) {
        int start = beginning, end = nums.length - 1;
        int closestSumOfTwo = nums[start] + nums[end];

        int diff = Math.abs(target - closestSumOfTwo);
        
        while(start < end) {
            int addUp = nums[start] + nums[end];

            if(addUp == target) {
                return target;
            } else if (addUp > target) {
                end--;
                if (addUp - target < diff) {
                    closestSumOfTwo = addUp;
                    diff = addUp - target;
                }
            } else {
                start++;
                if (target - addUp < diff) {
                    closestSumOfTwo = addUp;
                    diff = target - addUp;
                }
            }
        }
        return closestSumOfTwo;
    }
}