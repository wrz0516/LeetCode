package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q739 {
    //1、暴力法
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] answer = new int[temperatures.length];
//        for(int i=0;i<answer.length;i++){
//            for(int j=i+1;j<answer.length;j++){
//                if(temperatures[j]>temperatures[i]) {
//                    answer[i]=j-i;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
    //2、单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for(int i=1;i<temperatures.length;i++){
            if(temperatures[i]<=temperatures[stack.getLast()]){
                stack.offer(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.getLast()]){
                    int top = stack.removeLast();
                    answer[top]=i-top;
                }
                stack.offer(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] answer = new Q739().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}
