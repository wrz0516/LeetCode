package Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<String>();
        int index = 0;
        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                StringBuffer sb = new StringBuffer();
                while(Character.isDigit(s.charAt(index))){
                    sb.append(s.charAt(index++));
                }
                String temp = sb.toString();
                stack.addLast(temp);
            }

            else if( Character.isLetter(s.charAt(index))||s.charAt(index)=='[') {
                stack.addLast(String.valueOf(s.charAt(index++)));
            }
            else{
                index++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.getLast())) {
                    sub.addFirst(stack.removeLast());
                }
                stack.removeLast();//把“[”弹出
                int time = Integer.parseInt(stack.removeLast()); //把重复次数弹出
                StringBuffer temp = new StringBuffer();
                String o = getString(sub);
                while(time-->0){
                    temp.append(o);
                }
                stack.addLast(temp.toString());
            }
        }
        return getString(stack);
    }

    public String getString(LinkedList<String> list){
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String res = new Q394().decodeString(s);
        System.out.println(res);
    }
}
