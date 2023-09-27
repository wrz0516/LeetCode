package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> num = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
//        list.add(num);
        backtracing(nums,0);
        return list;
    }

    public void backtracing(int[] nums,int start){
        list.add(new ArrayList<>(num));
        if(start>=nums.length){
            return;
        }
        for(int i=start;i<nums.length;i++){
            num.add(nums[i]);
            backtracing(nums,i+1);
            num.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new Q78().subsets(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
            System.out.println();
        }
    }
}
