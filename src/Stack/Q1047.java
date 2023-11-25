package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Q1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(!stack.isEmpty()){
                char temp = stack.peek();
                if(temp==ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }

        }
        char[] str= new char[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            str[i++]=stack.pollLast();
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String str = "abbaca";
        String res = new Q1047().removeDuplicates(str);
        System.out.println(res);
    }
}
