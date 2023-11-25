package Backtracing;

import java.util.*;

public class Q90 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> num = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracing(nums,0);
        return list;
    }

    public void backtracing(int[] nums,int start){
        list.add(new ArrayList<>(num));
        if(start>=nums.length){
            return;
        }
        for(int i = start;i<nums.length;i++){
            num.add(nums[i]);

            backtracing(nums,i+1);
            num.removeLast();
            while(i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> res = new Q90().subsetsWithDup(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
