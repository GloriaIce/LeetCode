/* Brute force 
Time limit exceeded
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int maxRoom = 1;
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                if (map.containsKey(j)) {
                    int newCount = map.get(j) + 1;
                    if (newCount > maxRoom) {
                        maxRoom = newCount;
                    }
                    map.put(j, newCount);
                } else {
                    map.put(j, 1);
                }
            }
        }
        return maxRoom;
    }
}

/*
Priority Queue
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {      
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            if (queue.peek() > intervals[i][0]) {
                queue.add(intervals[i][1]);
            } else {
                queue.poll();
                queue.add(intervals[i][1]);  
            }
        }
        return queue.size();
    }
}