package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        visited[0]=1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count=1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> roomList = rooms.get(cur);
            for (Integer i : roomList) {
                if(visited[i]==1) continue;
                queue.offer(i);
                visited[i]=1;
                count++;
            }
        }
        return count==rooms.size();
    }

    public static void main(String[] args) {

    }
}
