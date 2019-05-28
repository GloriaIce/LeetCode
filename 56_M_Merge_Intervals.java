/*
Given a collection of intervals, merge all overlapping intervals.

这题不难，但是细节的坑比较多
1. 注意[[1, 2], [2, 3]] 算overlapping
2. merge的时候注意可能当前这个pair的end比之前的大 e.g. [[1, 4], [2, 3]] 应取max
3. 最后一个pair容易忘记写进去
4. 存储的方法。ArrayList转Array的方法会转成Interger[][]，无法避免循环。
    不如新建一个同样长度的array，往里面写。或如下解，直接在原有array上改动。
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        
        int pos = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentEnd) {
                // merge
                currentEnd = Math.max(intervals[i][1], currentEnd);
            } else {
                intervals[pos][0] = currentStart;
                intervals[pos][1] = currentEnd;
                pos++;
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
            
            if (i == intervals.length - 1) {
                intervals[pos][0] = currentStart;
                intervals[pos][1] = currentEnd;
            }
        }
        
        int[][] result = new int[pos + 1][2];
        for (int i = 0; i < pos + 1; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        
        return result;
    }
}