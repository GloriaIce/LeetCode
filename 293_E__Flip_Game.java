public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() == 0) return result;
        
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' ){
                StringBuilder temp = new StringBuilder(s);
                temp.setCharAt(i, '-');
                temp.setCharAt(i + 1, '-');
                result.add(temp.toString());
            }
        }
        return result;
    }
}