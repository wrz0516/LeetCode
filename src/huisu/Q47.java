package huisu;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        backtracing(nums);
        return list;
    }

    public void backtracing(int nums[]){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
            temp.add(nums[i]);
            used[i]=true;
            backtracing(nums);
            temp.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new Q47().permuteUnique(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
