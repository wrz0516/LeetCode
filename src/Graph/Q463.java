package Graph;

public class Q463 {
    public int islandPerimeter(int[][] grid) {
        int sum=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==1){
                    sum+=getLength(grid,i,j);
                }
            }
        }
        return sum;
    }

    public int getLength(int[][] grid,int x,int y){
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int sum=0;
        for(int i=0;i< dir.length;i++){
            int curX = x+dir[i][0];
            int curY = y+dir[i][1];
            if(isQualified(grid,curX,curY)&&grid[curX][curY]==1){
                sum++;
            }
        }
        return 4-sum;
    }

    public boolean isQualified(int[][] grid,int x,int y){
        if(x<0||x>= grid.length||y<0||y>= grid[0].length) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int res = new Q463().islandPerimeter(grid);
        System.out.println(res);
    }
}
