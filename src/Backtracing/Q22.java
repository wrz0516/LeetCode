package Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q22 {
    List<String> list = new ArrayList<>();
    LinkedList<Character> temp = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        backtracing(n,n,n);
        return list;
    }

    public void backtracing(int left,int right,int n){
        if(temp.size()==2*n){
            String str = Arrays.toString(temp.toArray()).replace(", ","");
            list.add(str.substring(1,str.length()-1));
            return;
        }
        if(left>0){
            temp.add('(');
            backtracing(left-1,right,n);
            temp.removeLast();
        }
        if(right>left){
            temp.add(')');
            backtracing(left,right-1,n);
            temp.removeLast();
        }

    }


    public static void main(String[] args) {
        List<String> list = new Q22().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
