package Array;

import java.util.*;

public class Q239 {
    public class MyStack{
        Deque<Integer> deque = new LinkedList<>();
        void pop(int num){
            if(!deque.isEmpty()&&deque.peek()==num){
                deque.removeFirst();
            }
        }
        void push(int num){
            while (!deque.isEmpty()&&deque.getLast()<num){
                deque.removeLast();
            }
            deque.add(num);
        }

        int peek(){
            return deque.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0,r=l+k;
        MyStack stack = new MyStack();
        int[] res = new int[nums.length-k+1];
        for(int i=l;i<r;i++){
            stack.push(nums[i]);
        }
        res[l]=stack.peek();
        l++;
        r++;
        while(r<=nums.length){
            stack.pop(nums[l-1]);
            stack.push(nums[r-1]);
            res[l]=stack.peek();
            l++;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={-7,-8,7,5,7,1,6,0};
        int k=4;
        int[] res = new Q239().maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(res));
    }
}
