package Array;

public class Q704 {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Q704 demo=new Q704();
        int[] x={-1,0,3,5,9,12};
//        int target=10;
        int res=demo.search(x,13);
        System.out.println(res);

    }
}
