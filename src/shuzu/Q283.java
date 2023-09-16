package shuzu;

public class Q283 {
//    public void moveZeroes(int[] nums) {
//        if(nums.length==0) return;
//        int left = nums.length-1;
//        int right = nums.length-1;
//        while(left>=0){
//            if(nums[left]==0&&left<right){
//                for(int temp = left+1;temp<=right;temp++){
//                    nums[temp-1]=nums[temp];
//                }
//                nums[right] = 0;
//                right--;
//            }
//           left--;
//        }
//    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        while(right<len){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,0,1,12};
        new Q283().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
