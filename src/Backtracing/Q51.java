package Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    List<List<String>> list = new ArrayList<>();
//    LinkedList<String> temp = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars,'.');
        }
        backtracing(n,0,chessboard);
        return list;
    }

    void backtracing(int n,int row,char[][] chessboard){
        if(row==n){
            list.add(array2list(chessboard));
            return;
        }
        for(int i=0;i<n;i++){ //控制列
            if(isValid(row,i,n,chessboard)){
                chessboard[row][i]='Q';
                backtracing(n,row+1,chessboard);
                chessboard[row][i]='.';
            }
        }
    }

    List array2list(char[][] array){
        List<String> strs = new ArrayList<>();
        for (char[] chars : array) {
            strs.add(String.copyValueOf(chars));
        }
        return strs;
    }

    boolean isValid(int row,int col,int n,char[][] chessboard){
        //列
        for(int i=0;i<row;i++){
            if(chessboard[i][col]=='Q') return false;
        }
        //对角线
        for(int i=col-1,j=row-1;i>=0&&j>=0;i--,j--){

                if(chessboard[j][i]=='Q') return false;

        }
        //副对角线
        for(int i=col+1,j=row-1;i<n&&j>=0;i++,j--){

                if(chessboard[j][i]=='Q') return false;

        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new Q51().solveNQueens(n);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
