package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        Set<Integer> set=new HashSet<>();
        set.add(n);
        while(true){
            String temp=String.valueOf(n);
            int sum=0;
            for(int i=0;i<temp.length();i++){
                sum+=Math.pow((temp.charAt(i)-'0'),2);
            }
            if(set.contains(sum)){
                return false;
            }
            if(sum==1){
                return true;
            }
            set.add(sum);
            n=sum;
        }
    }

    public static void main(String[] args) {
        int n=1;
        Q202 demo=new Q202();
        boolean res= demo.isHappy(n);
        System.out.println(res);
    }
}


