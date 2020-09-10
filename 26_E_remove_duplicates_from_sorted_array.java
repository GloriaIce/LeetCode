class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 1;
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            while ((i < nums.length - 1) && (nums[i] == nums[i + 1])) {
                i++;
            }
            if (i < nums.length - 1){
                nums[pos] = nums[i + 1];
                pos++;
            }
        }

        return pos;
    }
}