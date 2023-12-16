package Sort;

public class Q75 {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        quickSort(left,right,nums);
    }

    public void quickSort(int start,int end,int[] nums){
        int left=start,right=end;
        if(left>=right) return;
        int temp = nums[left];
        while(left<right){
            while(left<right&&nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];

            while(left<right&&nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        quickSort(start,left-1,nums);
        quickSort(left+1,end,nums);
    }
}
