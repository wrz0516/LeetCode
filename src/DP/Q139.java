package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];

        dp[0]=1;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String temp = s.substring(j,i);
                if(wordDict.contains(temp)&&dp[j]==1){
                    dp[i]=1;
                }
            }
        }
        if(dp[s.length()]>0) return true;
        else return false;
    }

    public static void main(String[] args) {
        String s="aaaaaaa";
        String[] strs = {"aaaa","aaa"};
        List<String> wordict = Arrays.asList(strs);
        boolean res = new Q139().wordBreak(s,wordict);
        System.out.println(res);
    }
}
