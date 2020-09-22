class Solution {
    public int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int nextWrite = end;
        int[] result = new int[A.length];

        while (start != end) {
        	int startSquare = A[start] * A[start];
        	int endSquare = A[end] * A[end];

        	if (startSquare < endSquare) {
        		result[nextWrite] = endSquare;
                nextWrite--;
        		end--;
        	} else {
        		result[nextWrite] = startSquare;
                nextWrite--;
        		start++;
        	}
        }
        result[nextWrite] = A[start] * A[start];
        return result;
    }
}