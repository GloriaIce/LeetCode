/*
面试时先问面试官写recursion还是while-loop
both ok写while-loop
sorted array默认是升序的
*/


/*二分法模版 —— binary search*/
/* 求last position时改if else里面的操作*/
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2; // 防止溢出，装逼用
            if (nums[mid] == target){
                end = mid;
            } else if (nums[mid] < target){
                start = mid;
            } else{
                end = mid;
            }
        }
        
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}

/* Implement int sqrt(int x). Compute and return the square root of x.*/
/* double 循环退出条件设成(end - start) < 10e-6 */
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        long start = 0;
        long end = x / 2 + 1;
        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            if (mid * mid <= x){
                start = (int) mid;
            }else{
                end = mid;
            }
        }
        
        if(end * end <= x){
            return (int) end;
        }else{
            return (int) start;
        }
    }
}

/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/
// 把二维数组当成一维数组处理
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if (number == target){
                return true;
            } else if (number < target){
                start = mid;
            } else{
                end = mid;
            }
        }
        
        if (matrix[start / column][start % column] == target){
            return true;
        }
        if (matrix[end / column][end % column] == target){
            return true;
        }
        return false;
    }
}
// 先确定在哪一行，再看在哪一列，两个binary search


/* Intersection of Two Arrays */
// Binary Search
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<Integer>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            int[] returnValue = new int[0];
            return returnValue;
        }
        
        Arrays.sort(nums1);
        for (int num : nums2){
            if (binarySearch(nums1, num)){
                result.add(num);
            }
        }
        
        int[] returnValue = new int[result.size()];
        int i = 0;
        for (Integer num : result){
            returnValue[i++] = num;
        }
        return returnValue;
    }
    
    public boolean binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return true;
            }else if (nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if (nums[start] == target || nums[end] == target){
            return true;
        }else {
            return false;
        }
    }
}

// Hash Set, O(n) 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            int[] returnValue = new int[0];
            return returnValue;
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums1){
            hs.add(num);
        }
        for (int num : nums2){
            if (hs.contains(num)){
                result.add(num);
                hs.remove(num);
            }
        }
        int[] returnValue = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            returnValue[i] = result.get(i);
        }
        return returnValue;
    }
}


/* Is Subsequence */

// 递归
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;

        if (!t.contains(s.substring(0,1))){
            return false;
        }
        int k = t.indexOf(s.charAt(0));
        return isSubsequence(s.substring(1), t.substring(k + 1));
    }
}

// 扫描， O(n)
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0){
            return true;
        }
        if (t == null || t.length() == 0){
            return false;
        }
        
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if (i == s.length()){
            return true;
        }else{
            return false;
        }
    }
}