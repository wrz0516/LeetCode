package DP;

public class Q647 {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int res = 0;
        for(int i = s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)!=s.charAt(i)) {
                    continue;
                }
                else{
                    if(j-i<=1) {
                        res ++;
                        dp[i][j]=1;
                    }
                    else{
                        res+=dp[i+1][j-1];
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        int res = new Q647().countSubstrings(s);
        System.out.println(res);
    }
}
