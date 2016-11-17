// O(n^2)
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        for (int i = 1; i <= nums.length; i++){
            boolean exists = false;
            for (int num : nums){
                if (num == i){
                    exists = true;
                    break;
                }
            }
            if (!exists){
                result.add(i);
            }
        }
        return result;
    }
}

// O(n) time, O(n) space
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums){
            set.add(num);
        }
        
        for (int i = 1; i <= nums.length; i++){
            if (!set.contains(i)){
                result.add(i);
            }
        }
        
        return result;
    }
}

// O(n) time, O(1) space
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        for (int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        
        for (int i = 1; i <= nums.length; i++){
            if (nums[i - 1] > 0){
                result.add(i);
            }
        }
        
        return result;
    }
}