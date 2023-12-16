package Array;

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i]>0&&nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
                swap(nums,i);
            }
        }
        int i=0;
        for(;i<len;i++){
            if(i!=nums[i]-1) return i+1;

        }
        return len+1;
    }

    public void swap(int[] nums,int i){
        int temp=nums[nums[i]-1];
        nums[nums[i]-1]=nums[i];
        nums[i]=temp;
    }

    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        int res = new Q41().firstMissingPositive(nums);
        System.out.println(res);
    }
}
