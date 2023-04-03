package stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    Queue<Integer> temp;
    public MyStack() {
        queue = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        while(queue.size()>1){
            int num = queue.poll();
            temp.offer(num);
        }
        int res= queue.poll();
        while(!temp.isEmpty()){
            queue.offer(temp.poll());
        }
        return res;
    }

    public int top() {
        int res = this.pop();
        queue.offer(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
