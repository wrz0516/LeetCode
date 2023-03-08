package shuzu;
import java.util.Arrays;
import java.util.Scanner;
public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int r=0,c=0,i=1,row_sum=0,col_sum=0,num=0;
        while(i<=n*n){
            int temp=c+n-num;
            while(c<temp){
                matrix[r][c++]=i++;
            }
            num+=1;
            c--;
            r++;
            temp=r+n-num;
            while(r<temp){
                matrix[r++][c]=i++;
            }
            r--;
            c--;
            temp=c-(n-num);
            while(c>temp){
                matrix[r][c--]=i++;
            }
            c++;
            r--;
            num+=1;
            temp=r-(n-num);
            while(r>temp){
                matrix[r--][c]=i++;
            }
            r++;
            c++;
        }
        return matrix;
    }
    public static void main(String[] args) {
        Q59 demo=new Q59();
        int n=5;
        int[][] res=demo.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(res[i][j]);
            }
        }


    }
}
