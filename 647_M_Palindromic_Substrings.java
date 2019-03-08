// O(n^3) Brute force
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if(isPalindromic(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPalindromic(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2 ; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

// !! Wrong O(n^2) solution 只数了string长度为奇数的
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int center = 0; center < s.length(); center++) {
            count++;
            int dis = 1;
            while(dis <= (Math.min(center, s.length() - center - 1))) {
                if (s.charAt(center - dis) == s.charAt(center + dis)){
                    count++;
                }
                dis++;
            }
        }
        return count;
    }
}

// O(n^2) 从center开始，分奇偶情况讨论
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int center = 0; center < s.length(); center++) {
            count++;

            // 奇
            int dis = 1;
            while(dis <= (Math.min(center, s.length() - center - 1))) {
                if (s.charAt(center - dis) == s.charAt(center + dis)){
                    count++;
                } else {
                    break;
                }
                dis++;
            }
            
            // 偶
            dis = 1;
            if (center < s.length() - 1 
                    && (s.charAt(center) == s.charAt(center + 1))) {
                count++;
                while(dis <= (Math.min(center, s.length() - center - 2))) {
                    if (s.charAt(center - dis) == s.charAt(center + dis + 1)){
                        count++;
                    } else {
                        break;
                    }
                    dis++;
                }
            }
        }
        return count;
    }
}

// O(n^2) 利用 % 2 合并奇偶情况
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while(left >= 0 && right < s.length() 
                  && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}

// ----------------- O(n)--------------------------
/**
Manacher's Algorithm [Accepted]
Intuition

Manacher's algorithm is a textbook algorithm that finds in linear time, the maximum size palindrome
for any possible palindrome center. If we had such an algorithm, finding the answer is straightforward.

What follows is a discussion of why this algorithm works.

Algorithm

Our loop invariants will be that center, right is our knowledge of the palindrome with the largest 
right-most boundary with center < i, centered at center with right-boundary right. Also, i > center, 
and we've already computed all Z[j]'s for j < i.

When i < right, we reflect i about center to be at some coordinate j = 2 * center - i. Then, 
limited to the interval with radius right - i and center i, the situation for Z[i] is the same as 
for Z[j].

For example, if at some time center = 7, right = 13, i = 10, then for a string like 
A = '@#A#B#A#A#B#A#'`, the `center` is at the `'#'` between the two middle `'A'`'s, the right boundary 
is at the last `'#'`, `i` is at the last `'B'`, and `j` is at the first `'B'`. Notice that limited to 
the interval `[center - (right - center), right]` (the interval with center `center` and right-boundary 
`right`), the situation for `i` and `j` is a reflection of something we have already computed. 
Since we already know `Z[j] = 3`, we can quickly find `Z[i] = min(right - i, Z[j]) = 3`. 
Now, why is this algorithm linear? The while loop only checks the condition more than once when 
`Z[i] = right - i`. In that case, for each time `Z[i] += 1`, it increments `right`, and `right` 
can only be incremented up to `2*N+2` times. Finally, we sum up `(v+1) / 2` for each `v in Z`. 
Say the longest palindrome with some given center C has radius R. Then, the substring with center C 
and radius R-1, R-2, R-3, ..., 0 are also palindromes. Example: `abcdedcba` is a palindrome with center 
`e`, radius 4: but `e`, `ded`, `cdedc`, `bcdedcb`, and `abcdedcba` are all palindromes. We are dividing 
by 2 because we were using half-lengths instead of lengths. For example we actually had the palindrome 
`a#b#c#d#e#d#c#b#a`, so our length is twice as big.
*/
class Solution {
    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
}