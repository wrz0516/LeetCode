package huisu;

import java.util.*;

public class Q491 {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
//    boolean[] used;
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracing(nums,0);
        return list;
    }

    public void backtracing(int[] nums,int start){
        if(start>= nums.length ){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i])||(!temp.isEmpty()&&nums[i]<temp.getLast())) continue;
            if(temp.isEmpty()||nums[i]>=temp.getLast()){
                set.add(nums[i]);
                temp.add(nums[i]);
                if(temp.size()>1){
                    list.add(new ArrayList<>(temp));
                }
            }
            backtracing(nums,i+1);
            temp.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] nums={4,4,3,2,1};
        List<List<Integer>> res = new Q491().findSubsequences(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
