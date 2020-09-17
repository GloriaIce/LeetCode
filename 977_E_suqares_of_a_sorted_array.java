class Solution {
    public int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int nextWrite = end;
        int[] result = new int[]{A.length};

        while (start != end) {
        	int startSquare = Math.pow(A[start], 2);
        	int endSquare = Math.pow(A[end], 2);

        	if (startSquare < endSquare) {
        		result[nextWrite] = endSquare;
        		end--;
        	} else {
        		result[nextWrite] = startSquare;
        		start++;
        	}
        }
        result[start] = Math.pow(A[start], 2);
        return result;
    }
}