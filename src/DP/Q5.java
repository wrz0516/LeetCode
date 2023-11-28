package DP;

public class Q5 {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String res = new String();
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)!=s.charAt(i)) continue;
                else{
                    if(j-i<=1){

                        dp[i][j]=1;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]==1&&j-i+1>res.length()) res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Q5().longestPalindrome(s));
    }
}
