package HashTable;

import java.util.*;

public class Q128 {
    /*
    解法一：先排序，但是时间复杂度为O(nlgn),不符合要求
     */
//    public int longestConsecutive(int[] nums) {
//        if(nums.length==0) return 0;
//        Arrays.sort(nums);
//        Map<Integer,Integer> map = new HashMap<>();
//        int max = 0;
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i]-1)){
//                int len = map.get(nums[i]-1)+1;
//                map.put(nums[i],len);
//                max = len>max?len:max;
//            }else{
//                map.put(nums[i],1);
//            }
//        }
//        return max;
//    }
    /*
    解法二：首先判断该书有没有前趋，有前趋则直接跳过
     */
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<Integer>(); //去重
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) { //如果数组中包含前趋，则跳过
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums ={4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        int res = new Q128().longestConsecutive(nums);
        System.out.println(res);
    }
}
