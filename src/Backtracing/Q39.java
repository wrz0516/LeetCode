package Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> temp =  new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracing(candidates,0,target,0);
        return list;
    }

    public void backtracing(int[] candidates,int start,int target,int sum){
        if(sum==target){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtracing(candidates,i,target,sum);
            temp.removeLast();
            sum-=candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target=8;
        List<List<Integer>> res = new Q39().combinationSum(candidates,target);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
