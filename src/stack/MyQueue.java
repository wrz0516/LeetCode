package stack;

import java.util.Stack;
//232题
public class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> temp;
    public MyQueue() {
        stack = new Stack<Integer>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while(!stack.isEmpty()){
            int num = stack.pop();
            temp.push(num);
        }
        int res = temp.pop();
        while(!temp.isEmpty()){
            int num = temp.pop();
            stack.push(num);
        }
        return res;
    }

    public int peek() {
        while(!stack.isEmpty()){
            int num = stack.pop();
            temp.push(num);
        }
        int res = temp.peek();
        while(!temp.isEmpty()){
            int num = temp.pop();
            stack.push(num);
        }
        return res;
    }

    public boolean empty() {
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
