public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int index = 0;
        int sum = 0;
        for (String s : sentence) {
            sum += s.length();
        }
        for (int i = 0; i < rows; i++){
        	int colsRemain = cols;
        	while (colsRemain > 0){
        		if (colsRemain >= sentence[index].length()){
        			colsRemain -= sentence[index].length();
        			colsRemain -= 1;
        			if (index + 1 >= sentence.length){
        				index = 0;
        				count += 1 + colsRemain / (sum + sentence.length);
        				colsRemain = colsRemain % (sum + sentence.length);
        			}else{
        				index++;
        			}
        		} else{
        			colsRemain = 0;
        		}
        	}
        }
        return count;
    }
}