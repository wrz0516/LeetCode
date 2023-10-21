package Greedy;

public class Q55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length<=1) return true;
        for(int i=0;i<=cover;i++){
            cover = Math.max(i+nums[i],cover);
            if(cover>=nums.length-1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2,5,0,0};
        boolean res = new Q55().canJump(nums);
        System.out.println(res);
    }
}
