/*
[0,0,1,1,1,1,2,3,3]
[1,1,1,2,2,3]
[1,2,3]
[1,1,2,2,3,3,3]
[1,2,2,3,4,5,5]
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int count = 1;
        
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
                count = 1;
            } else if (count == 1) {
                nums[++slow] = nums[fast];
                count++;
            }
        }
        return slow + 1;
    }
}