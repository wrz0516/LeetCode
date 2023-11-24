package Strings;

import java.util.HashSet;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int left=0,right=1;
        int res = Integer.MIN_VALUE;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(s.charAt(left));
        while(right<=s.length()){
            if(right==s.length()) {
                res=Math.max(res,right-left);
                break;
            }
            if(hashSet.contains(s.charAt(right))){
                res=Math.max(res,right-left);
                hashSet.remove(s.charAt(left));
                left=left+1;
//                right=right+1;
            }else{
                hashSet.add(s.charAt(right));
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = new Q3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
