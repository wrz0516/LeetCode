package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Q20 {
    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for(int i=0;i<s.length();i++) {
//            char ch = s.charAt(i);
//            if (ch == '(' || ch == '{' || ch == '[') {
//                stack.push(ch);
//            } else {
//                if(stack.isEmpty()){
//                    return false;
//                }
//                if (ch == ')') {
//                    char top = stack.peek();
//                    if (top == '(') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                if (ch == '}') {
//                    char top = stack.peek();
//                    if (top == '{') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                if (ch == ']') {
//                    char top = stack.peek();
//                    if (top == '[') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        if(stack.isEmpty()){
//            return true;
//        }else{
//            return false;
//        }
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{[()]}";
        boolean res = new Q20().isValid(str);
        System.out.println(res);
    }
}
