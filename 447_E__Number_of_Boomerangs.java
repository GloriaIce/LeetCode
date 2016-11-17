public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        if (points == null || points.length == 0){
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                
                int d = getDistanceSquare(points[i], points[j]);
                
                if (map.containsKey(d)){
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }
            
            for(int val : map.values()) {
                result += val * (val - 1);
            }
            map.clear();
        }
        return result;
    }
    
    public int getDistanceSquare(int[] a, int[] b){
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}