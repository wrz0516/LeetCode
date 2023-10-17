package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q46 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        backtracing(nums,0);
        return list;
    }

    public void backtracing(int[] nums,int cur){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            temp.add(nums[i]);
            used[i]=true;
            backtracing(nums,i);
            temp.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res = new Q46().permute(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
