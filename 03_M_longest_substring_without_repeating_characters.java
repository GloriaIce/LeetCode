/**
    Given a string s, find the length of the longest substring without repeating characters.

     

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    Example 4:

    Input: s = ""
    Output: 0
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        
        for (int i = 0; i < s.length(); i++) {
            while(!set.add(s.charAt(i))) {
                set.remove(s.charAt(slow));
                slow++;
            }  
            
            result = Math.max(result, set.size());
        }
        
        return result;
    }
}