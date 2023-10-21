package Greedy;

public class Q122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            sum+=Math.max(prices[i]-prices[i-1],0);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {2,1,4};
        int res = new Q122().maxProfit(prices);
        System.out.println(res);
    }
}
