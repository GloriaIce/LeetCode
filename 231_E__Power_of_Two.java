public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (true){
            if (n == 1){
                return true;
            }
            if (n == 0 || n % 2 != 0){
                return false;
            }
            n = n / 2;
        }
    }
}