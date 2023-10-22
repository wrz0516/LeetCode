package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Q406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1]; //升序
                return o2[0]-o1[0]; //降序
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
//        int[][] people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    }
}
