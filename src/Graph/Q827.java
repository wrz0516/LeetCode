package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q827 {
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int size = grid.length,mark=2;
        Map<Integer, Integer> getSize = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==1){
                    int areaSize = 1+dfs(grid,i,j,mark);
                    getSize.put(mark++,areaSize); //编号为mark的面积
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]!=0) continue;
                Set<Integer> hashSet = new HashSet<>();
                int curSize=1;
                for (int[] ints : position) {
                    int curX = i+ints[0];
                    int curY = j+ints[1];
                    if(curX<0 || curX>= grid.length || curY<0 || curY>= grid[0].length) continue;
                    int curMark = grid[curX][curY];
                    if (hashSet.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    hashSet.add(curMark);
                    curSize+=getSize.get(curMark);
                }
                ans = Math.max(ans,curSize);
            }
        }
        return ans==Integer.MIN_VALUE?size*size:ans;
    }

    public int dfs(int[][] grid,int x,int y,int mark){
        int ans = 0;
        grid[x][y]=mark;
        for (int[] ints : position) {
            int curX = x+ints[0];
            int curY = y+ints[1];
            if(curX<0 || curX>= grid.length || curY<0 || curY>= grid[0].length) continue;
            if(grid[curX][curY]==1){
                ans += 1+dfs(grid,curX,curY,mark);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,0}};
        int res = new Q827().largestIsland(grid);
        System.out.println(res);
    }
}
