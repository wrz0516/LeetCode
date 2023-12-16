package Array;

import java.util.Arrays;

public class Q189 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[end];
            nums[end]=nums[start];
            nums[start]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k =3;
        new Q189().rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
