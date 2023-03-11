package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] table1=new int[1001];
        int[] table2=new int[1001];
        for(int i=0;i<nums1.length;i++){
            table1[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            table2[nums2[i]]++;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<1001;i++){
            if(table1[i]>0&&table2[i]>0){
                set.add(i);
            }
        }
        int[] array=new int[set.size()];
        int k=0;
        for(Integer i:set){
            array[k++]=i;
        }
        return array;
    }
    public static void main(String[] args){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        Q349 demo=new Q349();
        int[] res= demo.intersection(nums1,nums2);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
