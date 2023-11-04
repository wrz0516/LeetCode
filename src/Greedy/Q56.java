package Greedy;

import sun.security.krb5.internal.crypto.Aes256CtsHmacSha1EType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
//        if(intervals.length<=1) return intervals;
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] range=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=range[1]){
                range[1]=Math.max(intervals[i][1],range[1]);
            }else{
                list.add(range);
                range=intervals[i];
            }
        }
        list.add(range);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Q56().merge(intervals);
        for (int[] re : res) {
            System.out.println(re);
        }
    }
}
