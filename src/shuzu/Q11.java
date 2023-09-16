package shuzu;
/*
乘最多水的容器
 */
public class Q11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, max = 0;

        while(left<right){
            int cur = (right-left)*Math.min(height[left],height[right]);
            max = Math.max(cur,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,3,2,5,25,24,5};
        int res = new Q11().maxArea(height);
        System.out.println(res);
    }
}
