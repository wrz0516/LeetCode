package Stack;

import java.util.Arrays;
import java.util.LinkedList;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length<=1) return asteroids;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<asteroids.length;i++) {
            int cur = asteroids[i];
            if(i==0) stack.addLast(cur);
            else{
                if(!stack.isEmpty()&&isSame(stack.peekLast(),cur)){
                    stack.addLast(cur);
                }else{
                    while (!stack.isEmpty()&&!isSame(stack.peekLast(),cur)){
                        int top = stack.removeLast();
                        if(top+cur==0) cur=0;
                        else{
                            cur = Math.abs(top)>Math.abs(cur)?top:cur;
                        }
                    }
                    if(cur!=0){
                        stack.add(cur);
                    }

                }
            }
        }
        int[] res = new int[stack.size()];
        int start=0;
        for (Integer i : stack) {
            res[start++]=i;
        }
        return res;
    }

    public boolean isSame(int a, int b){
        if(a>=0&&b>=0 || a<0&&b<0 || a<0&&b>0) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] asteroids = {1,-1,-2,-2};
        int[] res = new Q735().asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }
}
