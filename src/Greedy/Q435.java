package Greedy;

import java.util.Arrays;
import java.util.Comparator;
//解题的关键是求出重叠区域
public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int res=0;
        int left = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<left){ //重叠情况
                left = Math.min(left,intervals[i][1]);
                res++;
            }else{ //非重叠情况
                left=intervals[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        int res = new Q435().eraseOverlapIntervals(intervals);
        System.out.println(res);
    }
}
