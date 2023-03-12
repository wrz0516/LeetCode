package HashTable;

import java.util.HashMap;
import java.util.Map;
//分组+哈希表
public class Q454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      int sum=0;
      Map<Integer,Integer> map=new HashMap<>();
      for (int i:nums1){
          for(int j:nums2){
              int temp=i+j;
              map.put(temp,map.getOrDefault(temp,0)+1);
          }
      }
      for (int i:nums3){
          for(int j:nums4){
              int temp=i+j;
              int rest=0-temp;
              if(map.containsKey(rest)){
                  sum+=map.get(rest);
              }
          }
      }
      return sum;
    }
    public static void main(String[] args){
        int[] nums1={1,2};
        int[] nums2={-2,-1};
        int[] nums3={-1,2};
        int[] nums4={0,2};
        Q454 demo=new Q454();
        int res=demo.fourSumCount(nums1,nums2,nums3,nums4);
        System.out.println(res);
    }
}
