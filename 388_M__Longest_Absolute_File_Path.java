// dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
public class Solution {
    public int lengthLongestPath(String input) {
    	int depth = 1;
    	int result = 0;
    	int[] depLength = new int[input.length() + 1];
    	int length = 0;
    	boolean isFile = false;
    	input += '\n';
        for (char c : input.toCharArray()){
        	if (c == '\n'){
        		if (isFile){
        			result = Math.max(result, depLength[depth - 1] + length);
        		} else {
        			depLength[depth] = depLength[depth - 1] + length + 1;
        		}
        		isFile = false;
        		length = 0;
        		depth = 1;
        	} else if (c == '\t'){
        		depth++;
        	} else if (c == '.'){
        		isFile = true;
        		length++;
        	} else{
        		length++;
        	}
        }
        return result;
    }
}