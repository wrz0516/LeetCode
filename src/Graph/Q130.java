package Graph;

import java.util.Arrays;

public class Q130 {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (visited[i][j]==0&&board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)) {
                    dfs(board, i, j, visited);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(visited[i][j]==0&&board[i][j]=='O') board[i][j]='X';
            }
        }
    }

    public void dfs(char[][] grid, int x, int y,int[][] visited){
        if( x<0 || x>= grid.length || y<0 || y>= grid[0].length || grid[x][y]=='X' || visited[x][y]==1) return;
        visited[x][y]=1;
        dfs(grid,x,y+1,visited);
        dfs(grid,x,y-1,visited);
        dfs(grid,x+1,y,visited);
        dfs(grid,x-1,y,visited);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] board = {{'O','O'},{'O','O'}};
        new Q130().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
