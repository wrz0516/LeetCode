package Array;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
//        int len=nums.length;
//        int sum=0;
//        int shortest=Integer.MAX_VALUE;
//        for(int i=0;i<len;i++){
//            for(int j=i;j<len;j++){
//                sum+=nums[j];
//                if(sum>=target){
//                    shortest = Math.min(shortest, j - i + 1);
//
//                    break;
//                }
//            }
//            sum=0;
//        }
//
//        return shortest==Integer.MAX_VALUE?0:shortest;
        int start=0,end=0,sum=0;
        int len=nums.length;
        int ans=Integer.MAX_VALUE;
        while(end<len){
            sum+=nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
                end++;
            }

        return ans==Integer.MAX_VALUE?0:ans;
    }
    public static void main(String[] args) {
        Q209 demo=new Q209();
        int[] x={1,2,3,4,5};
        int target=15;
        int res=demo.minSubArrayLen(target,x);
        System.out.println(res);

    }
}
