package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
//        int i=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] > target&&nums[i]>0) {
                return res;
            }

            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }

            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j-1]==nums[j]){
                    continue;
                }
//                j++;
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    long temp=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp<target){
                        left++;
                    }
                    else if(temp>target){
                        right--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }

                }

            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={2,2,2,2,2};
        int target=0;
        List<List<Integer>> res=new Q18().fourSum(nums,target);
        for(int i=0;i< res.size();i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
