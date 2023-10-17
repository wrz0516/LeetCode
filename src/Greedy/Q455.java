package Greedy;

import java.util.Arrays;

public class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int min = Math.max(0,g.length-s.length);
        int res = 0,cur=s.length-1;
        for(int i=g.length-1;i>=0&&cur>=0;i--){
            if(s[cur]>=g[i]) {
                cur--;
                res++;
            }
            else continue;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g={1,2};
        int[] s={1,2,3};
        int res = new Q455().findContentChildren(g,s);
        System.out.println(res);
    }
}
