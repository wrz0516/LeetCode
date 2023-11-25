package Graph;

public class Q1020 {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)) {
                    dfs(grid, i, j);
                }
            }
        }
        int sum=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) sum+=1;
            }
        }
        return sum;
    }
    public void dfs(int[][] grid, int x, int y){
        if(x<0 || x>= grid.length || y<0 || y>= grid[0].length || grid[x][y]==0) return;
        grid[x][y]=0;
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int res = new Q1020().numEnclaves(grid);
        System.out.println(res);
    }
}
