package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length<=1) return 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); //注意溢出问题
        int[] range = points[0];
        int sum=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=range[1]){
                range[0]=Math.max(range[0],points[i][0]);
                range[1]=Math.min(range[1],points[i][1]);
            }else{
                sum+=1;
                range[0]=points[i][0];
                range[1]=points[i][1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points={{-2147483646,-2147483645},{2147483646,2147483647}};
        int res = new Q452().findMinArrowShots(points);
        System.out.println(res);
    }
}
