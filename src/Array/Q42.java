package Array;
/*
 接雨水
 */
public class Q42 {
    public int trap(int[] height) {

        //暴力解法
//        if(height.length<3) return 0;
//        int sum = 0;
//        int l=0,r=0;
//        for(int i=0;i<1;i++){
//            l = Math.max(height[i],l);
//        }
//        for(int i=2;i<height.length;i++){
//            r = Math.max(r,height[i]);
//        }
//        int vol = Math.min(l,r)-height[1];
//        vol = vol>0?vol:0;
//        sum+=vol;
//        for(int i=2;i<height.length;i++){
//            l = Math.max(height[i-1],l);
//            if(r<=height[i]){
//                r=0;
//                for(int j=i+1;j<height.length;j++){
//                    r=Math.max(height[j],r);
//                }
//            }
//            vol = Math.min(l,r)-height[i];
//            vol = vol>0?vol:0;
//            sum+=vol;
//        }

//        for(int i =1;i<height.length-1;i++){
////            int l=0,r=0;
//            for(int j=0;j<i;j++){
//                l = Math.max(height[j],l);
//            }
//            for(int j=i+1;j<height.length;j++){
//                r = Math.max(r,height[j]);
//            }
//
//            int vol = Math.min(l,r)-height[i];
//            vol = vol>0?vol:0;
//            sum+=vol;
//        }
        //备忘录解法
//        int len = height.length;
//        if(len<3) return 0;
//        int[] l_max = new int[len];
//        int[] r_max = new int[len];
//        l_max[0] = height[0];
//        r_max[len-1] = height[len-1];
//
//        for(int i=1;i<len;i++){
//            l_max[i] = Math.max(l_max[i-1],height[i-1]);
//        }
//
//        for(int i=len-2;i>=0;i--){
//            r_max[i] = Math.max(r_max[i+1],height[i+1]);
//        }
//        for (int lMax : r_max) {
//            System.out.println("l_len:"+lMax);
//        }
//        int sum=0;
//        for(int i=1;i<len-1;i++){
//            int vol = Math.min(l_max[i],r_max[i])-height[i];
//            vol = vol>0?vol:0;
//            sum+=vol;
//        }
        // 双指针法
        int n = height.length;
        if(n<3) return 0;
        int left = 0, right = n - 1;
        int ans = 0;

        int l_max = height[0]; //l_max代表height[0..left]的最大值
        int r_max = height[n - 1]; //r_max代表height[right..n]的最大值

        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // ans += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
//        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int res = new Q42().trap(height);
        System.out.println(res);
    }
}
