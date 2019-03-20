// O(n * 2^n) Brute force
// 找到所有可能的string，再检查是否valid
class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
        result = generateAllPossibleStrings(result, 0, new char[n * 2]);
        return result;
    }
    
    // 递归
    private List<String> generateAllPossibleStrings(List<String> result, int pos, char[] current) {
        if (pos == current.length) {
        	// check validity
        	if (isValidParenthesis(current)) {
        		result.add(new String(current));
        	}
        } else {
            current[pos] = '(';
            generateAllPossibleStrings(result, pos + 1, current);
            current[pos] = ')';
            generateAllPossibleStrings(result, pos + 1, current);
        }
        return result;
    }

    private boolean isValidParenthesis(char[] current) {
    	int balance = 0;
    	for (int i = 0; i < current.length; i++) {
    		if (current[i] == '('){
    			balance++;
    		} else {
    			balance--;
    		}
    		if (balance < 0) {
    			return false;
    		}
    	}
    	if (balance != 0) {
    		return false;
    	}
    	return true;
    }
}

/** 利用以下观察结果：
if at any time, num("(") < n && num(")" < num("(")), then it is valid
*/
class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
    	result = generateAll(result, 0, 0, 0, new char[n * 2]);
    	return result;
    }

    private List<String> generateAll(List<String> result, int open, int close, int pos, char[] current) {
    	if (pos == current.length) {
    		result.add(new String(current));
    	}
    	if (open < current.length / 2) {
    		current[pos] = '(';
    		generateAll(result, open + 1, close, pos + 1, current);
    	}
    	if (close < open) {
    		current[pos] = ')';
    		generateAll(result, open, close + 1, pos + 1, current);
    	}
    	return result;
    }
}






