package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left=0,right=matrix[0].length-1;
        int top=0,bottom= matrix.length-1;
        while(true){
            if(bottom>=top){
                for(int i =left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
            }
            if(++top>bottom) break;

                for(int i=top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
            if(--right<left) break;


                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
            if(--bottom<top) break;

                for(int i=bottom;i>=top+1;i--){
                    list.add(matrix[i][left]);
                }
            if(++left>right) break;

        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{7},{9},{6}};
        List<Integer> res = new Q54().spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
