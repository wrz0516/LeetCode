package Graph;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pacific_visited=new int[heights.length][heights[0].length];
        int[][] atlantic_visited=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for (int j =0;j<heights[0].length;j++){
                if(i==0||j==0){
                    dfs(heights,i,j,pacific_visited,heights[i][j]);
                }
                if(i==heights.length-1 || j==heights[0].length-1){
                    dfs(heights,i,j,atlantic_visited,heights[i][j]);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific_visited[i][j]==1&&atlantic_visited[i][j]==1){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(j);
                    list.add(list1);
                }
            }
        }
        return list;
    }

    public void dfs(int[][] heights,int x,int y,int[][] visited,int pre){
        if(x<0 || x>= heights.length || y<0 || y>= heights[0].length || visited[x][y]==1 || heights[x][y]<pre) return;
        visited[x][y]=1;
        int cur = heights[x][y];
        dfs(heights,x-1,y,visited,cur);
        dfs(heights,x+1,y,visited,cur);
        dfs(heights,x,y+1,visited,cur);
        dfs(heights,x,y-1,visited,cur);
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res=new Q417().pacificAtlantic(heights);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
