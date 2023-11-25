package Backtracing;

public class Q79 {
    boolean flag=false;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)) {
                    visited[i][j]=true;
                    backtracing(board,word,1,i,j,visited);
                    visited[i][j]=false;
                }
            }
        }
        return flag;
    }

    void backtracing(char[][] board, String word, int idx, int x, int y,boolean[][] visited){
        int row=board.length;
        int col=board[0].length;
        if(idx>=word.length()){
            flag = true;
            return;
        }
        if(x>=row||y>=col) return;
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int i=0;i<4;i++){
            if(isValid(board,word.charAt(idx),x+dir[i][0],y+dir[i][1],visited)){
                visited[x+dir[i][0]][y+dir[i][1]]=true;
                backtracing(board,word,idx+1,x+dir[i][0],y+dir[i][1],visited);
                visited[x+dir[i][0]][y+dir[i][1]]=false;
            }
        }
//        if(isValid(board,word.charAt(idx),x,y-1,visited)){
//            visited[x][y-1]=true;
//            backtracing(board,word,idx+1,x,y-1,visited);
//        }
//        if(isValid(board,word.charAt(idx),x,y+1,visited)){
//            visited[x][y+1]=true;
//            backtracing(board,word,idx+1,x,y+1,visited);
//        }
//        if(isValid(board,word.charAt(idx),x-1,y,visited)){
//            visited[x-1][y]=true;
//            backtracing(board,word,idx+1,x-1,y,visited);
//        }
//        if(isValid(board,word.charAt(idx),x+1,y,visited)){
//            visited[x+1][y]=true;
//            backtracing(board,word,idx+1,x+1,y,visited);
//        }
    }

    boolean isValid(char[][] board, char ch, int x, int y, boolean[][] visited){
        int row=board.length;
        int col=board[0].length;
        if((y>=0&&y<col)&&(x>=0&&x<row)){
            if(visited[x][y]==false&&board[x][y]==ch) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'c','a','a'},{'a','a','a'},{'b','c','d'}};
        String word = "aab";
        boolean res = new Q79().exist(board,word);
        System.out.println(res);
    }

}
