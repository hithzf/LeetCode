package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. Merge Intervals
 * @author hzf
 * @see https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<int[]>();
        for(int[] interval : intervals){
            if(list.size() == 0){
                list.add(interval);
                continue;
            }
            int[] tail = list.getLast();
            if(tail[1] < interval[0]){
                list.add(interval);
                continue;
            }
            tail[1] = Math.max(tail[1], interval[1]);
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
