package DP;

public class Q509 {
//    public int fib(int n) {
//        int res = backtracing(n);
//        return res;
//    }
//
//    int backtracing(int cur){
//        if(cur==0){
//            return 0;
//        }else if(cur==1){
//            return 1;
//        }
//        int sum=backtracing(cur-1)+backtracing(cur-2);
//        return sum;
//    }
    public int fib(int n) {
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int res = new Q509().fib(n);
        System.out.println(res);
    }
}
