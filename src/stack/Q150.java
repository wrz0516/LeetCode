package stack;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];
            if(str.equals("+") ){
//                int res = stack.pop()+stack.pop();
                stack.push(stack.pop()+stack.pop());
            } else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if (str.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = new Q150().evalRPN(tokens);
        System.out.println(res);
    }
}
