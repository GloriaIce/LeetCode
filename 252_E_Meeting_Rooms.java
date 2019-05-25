/*
Problem:
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine 
if a person could attend all meetings.
 */

/*
Solution 1:
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Set<Integer> set = new HashSet();
        
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                if (set.contains(j)) {
                    return false;
                } else {
                    set.add(j);
                }
            }
        }
        return true;
    }
}

/*
Solution 2:
两两比较，两个item有冲突则全局有冲突
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] >= intervals[j][1] 
                    || intervals[i][1] <= intervals[j][0]) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}

/*
Solution 3:
先按照第一个元素sort array，
再一个一个比较是否当前的start大于上一个的结束
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {      
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
            
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}