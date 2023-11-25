package Array;

import java.util.*;

public class Q15 {
        public List<List<Integer>> threeSum(int[] nums){
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);

            for(int i =0;i<nums.length;i++){
                //1.当nums[i]大于0，说明没有满足的三元组
                if(nums[i]>0) return list;
                //2.跳过相同的元素
                if(i>0&&nums[i]==nums[i-1]) continue;
                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    int temp = nums[i]+nums[left]+nums[right];
                    if(temp<0){
                        left++;
                    }else if(temp>0){
                        right--;
                    }else{
                        list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        //3.记得跳过相同的元素
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
            return list;
        }




    public static void main(String[] args) {
        int[] nums={0,0,0,-1,0,1,2,-1,-4};
        List<List<Integer>> res=new Q15().threeSum(nums);
        for(int i=0;i< res.size();i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
