package shuzu;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] result=new int[right+1];
        int k=right;
        while(left<right){
            if(nums[left]*nums[left]<=nums[right]*nums[right]){
                result[k--]=nums[right]*nums[right];
                right--;
            }else{
                result[k--]=nums[left]*nums[left];
                left++;
            }
        }
        result[k]=nums[left]*nums[left];
        return result;
    }
    public static void main(String[] args) {
        Q977 demo=new Q977();
        int[] x={-4,-1,0,3,10};
//        int target=10;
        int[] res=demo.sortedSquares(x);
//        System.out.println(res);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
