package HashTable;

import java.util.*;

public class Q544 {
    public int leastBricks(List<List<Integer>> wall){
        HashMap<Integer, Integer> table = new HashMap<>();
        int num=0;
        for (List<Integer> integers : wall) {
            int sum=0;
            for (Integer integer : integers) {
                sum+=integer;
                table.put(sum, table.getOrDefault(sum,0)+1);
            }
            num=sum;
        }
        Set<Integer> set =  table.keySet();
        int max = 0;
        for (Integer i : set) {
            if(i!=num){
                max = Math.max(max,table.get(i));
            }
        }
        return wall.size()-max;
    }
}
