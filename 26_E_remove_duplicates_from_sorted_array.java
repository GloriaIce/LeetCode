/* O(n^2) */
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        
        for (int i = 0; i < length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < length; j++) {
                    nums[j-1] = nums[j];
                }
                length--;
                i--;
            }
        }
        return length;
    }
}

/* O(n) Solution */
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