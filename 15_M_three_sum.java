/**
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 *
 * [-4, -1, -1, 0, 1, 2]
 *
 * [-1, 0, 1, 2]
 */


/* Solution 1: HashSet and reuse twoSum */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (nums[i] != nums[i-1])) {
                List<List<Integer>> twosumResult = 
                        twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), 0 - nums[i]);
                for (List<Integer> pair : twosumResult) {
                    List<Integer> oneResult = new ArrayList();
                    oneResult.add(nums[i]);
                    oneResult.addAll(pair);
                    result.add(oneResult);
                }
            }
        }

        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        // Map<value, index>
        Set<Integer> set = new HashSet();
        Set<Integer> secondNumberSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i]) && !secondNumberSet.contains(nums[i])) {
                List<Integer> elements = new ArrayList<Integer>(Arrays.asList(target - nums[i], nums[i]));
                result.add(elements);
                secondNumberSet.add(nums[i]);
            }
            
            set.add(nums[i]);
        }
        
        return result;
    }
}

/* Solution 2 two pointers, reuse two sum */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> twosumResult = twoSum(nums, 0 - nums[i], i + 1);
            for (List<Integer> pair : twosumResult) {
                List<Integer> oneResult = new ArrayList();
                oneResult.add(nums[i]);
                oneResult.addAll(pair);
                result.add(oneResult);
            }
            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                i++;
            }
        }

        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int beginning) {
        List<List<Integer>> result = new ArrayList();
        int start = beginning, end = nums.length - 1;
        
        while(start < end) {
            int addUp = nums[start] + nums[end];
            if(addUp == target) {
                List<Integer> elements = new ArrayList<Integer>(Arrays.asList(nums[start], nums[end]));
                result.add(elements);
                do {
                    start++;
                }
                while((nums[start] == nums[start - 1]) && (start < end));

                do {
                    end--;
                } while((nums[end] == nums[end + 1]) && (start < end));
            } else if (addUp > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}