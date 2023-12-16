package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    public int orangesRotting(int[][] grid) {
//        int visited[][] = new int[grid.length][grid[0].length];
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) queue.add(new int[]{i,j});
            }
        }

        int num=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len>0){
                int[] cur = queue.poll();
                len--;
                for(int i=0;i<directions.length;i++){
                    int curX = cur[0]+directions[i][0];
                    int curY = cur[1]+directions[i][1];
                    if(isQualified(curX,curY,grid)&&grid[curX][curY]==1){
                        queue.add(new int[]{curX,curY});
                        grid[curX][curY]=2;
                    }
                }
            }
            if(!queue.isEmpty()) num++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return num;
    }

    public boolean isQualified(int x,int y,int[][] grid){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        int res = new Q994().orangesRotting(grid);
        System.out.println(res);
    }
}
