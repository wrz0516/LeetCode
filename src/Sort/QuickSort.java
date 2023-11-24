package Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums,int start,int end){
        if(start>=end) return;
        int i=start,j=end;
        int base=nums[start];
        while(i<j){
            while(i<j&&nums[j]>=base){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<=base){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=base;
        quickSort(nums,0,i-1);
        quickSort(nums,i+1,end);
    }

    public static void main(String[] args) {
        int[] nums={2,1,3,6,4,4,7};
        new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
