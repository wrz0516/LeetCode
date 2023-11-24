package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q797 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp.add(0);
        backtracing(graph,0);

        return list;
    }
    public void backtracing(int[][] graph,int cur){
        if(cur==graph.length-1){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<graph[cur].length;i++){
            int next = graph[cur][i];
            temp.add(next);
            backtracing(graph,next);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = new Q797().allPathsSourceTarget(graph);
    }
}
