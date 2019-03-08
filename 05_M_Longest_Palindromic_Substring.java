// Refer to No.647
class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String longest = "";
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while(left >= 0 && right < s.length() 
                  && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    longest = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return longest;
    }
}