/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * 
 * Two pointer问题，需仔细
 */

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        
        int[][] result = new int[A.length + B.length][2];
        int pResult = 0;
        int pA = 0;
        int pB = 0;
        
        while(pA != A.length && pB != B.length) {
            int[] intersection = getIntersection(A[pA], B[pB]);
            
            if (intersection != null) {
                result[pResult] = intersection;
                pResult++;
            }
            if (A[pA][1] < B[pB][1]) {
                pA++;
            } else if (A[pA][1] > B[pB][1]){
                pB++;
            } else {
                pA++;
                pB++;
            }
        }
        
        int[][] finalResult = new int[pResult][2];
        
        for(int i = 0; i < pResult; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        return finalResult;
    }
    
    private int[] getIntersection(int[] a, int[] b) {
        if ((b[0] > a[1]) || (b[1] < a[0])) {
            return null;
        } else {
            return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
        }
    }
}