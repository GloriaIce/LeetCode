public class ValidWordAbbr {
    HashMap<String, String> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<String, String>();
        for (String word : dictionary ){
            if (word == null || word.length() == 0) continue;
            
            String abbr = buildString(word);
            
            if (dict.get(abbr) != null && !dict.get(abbr).equals(word)){
                dict.put(abbr, dict.get(abbr) + word);
            }else{
                dict.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) return true;
        
        String abbr = buildString(word);
        
        return !(dict.get(abbr) != null && !dict.get(abbr).equals(word));
    }
    
    private String buildString(String word){
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");