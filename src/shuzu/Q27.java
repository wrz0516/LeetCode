package shuzu;

public class Q27 {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]==val){
                nums[left]=nums[right];
                right--;
            }else if(nums[left]!=val){
                left++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Q27 demo=new Q27();
        int[] x={1};
//        int target=10;
        int res=demo.removeElement(x,1);
        System.out.println(res);
        for(int i=0;i<res;i++){
            System.out.println(x[i]);
        }
    }
}
