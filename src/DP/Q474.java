package DP;

public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        int[][] nums = new int[len][2];

        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0') nums[i][0]+=1;
                else if(strs[i].charAt(j)=='1') nums[i][1]+=1;
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=m;j>=nums[i][0];j--){
                for(int k=n;k>=nums[i][1];k--){
                    dp[j][k]=Math.max(dp[j][k],dp[j-nums[i][0]][k-nums[i][1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs={"10", "0001", "111001", "1", "0"};
        int m=5,n=3;
        int res = new Q474().findMaxForm(strs,m,n);
        System.out.println(res);
    }
}
