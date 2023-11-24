package Graph;

import erchashu.Q101;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q200 {
    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length]; //0：未访问
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0&&grid[i][j]=='1'){
                    visited[i][j]=1;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] cur=queue.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        for(int k=0;k<dir.length;k++){
                            int nextX=curX+dir[k][0];
                            int nextY =curY+dir[k][1];
                            
                            if(nextX<0||nextX>= grid.length||nextY<0||nextY>=grid[0].length) continue;
                            if(visited[nextX][nextY]==0&&grid[nextX][nextY]=='1'){
                                visited[nextX][nextY]=1;
                                queue.offer(new int[]{nextX,nextY});
                            }
                        }
                    }
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int res = new Q200().numIslands(grid);
        System.out.println(res);
    }
}
