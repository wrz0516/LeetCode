package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q383 {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character,Integer> map1=new HashMap<>();
//        Map<Character,Integer> map2=new HashMap<>();
//        for(int i=0;i<ransomNote.length();i++){
//            char ch=ransomNote.charAt(i);
//            map1.put(ch,map1.getOrDefault(ch,0)+1);
//        }
//        for(int i=0;i<magazine.length();i++){
//            char ch=magazine.charAt(i);
//            map2.put(ch,map2.getOrDefault(ch,0)+1);
//        }
//        for(Object i:map1.keySet()){
//            char ch=(char)i;
//            int times1=Integer.parseInt(String.valueOf(map1.get(ch)));
//            if(map2.containsKey(ch)){
//                int times2=Integer.parseInt(String.valueOf(map2.get(ch)));
//                if(times2<times1){
//                    return false;
//                }
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
public boolean canConstruct(String ransomNote, String magazine) {
    // 定义一个哈希映射数组
    int[] record = new int[26];

    // 遍历
    for(char c : magazine.toCharArray()){
        record[c - 'a'] += 1;
    }

    for(char c : ransomNote.toCharArray()){
        record[c - 'a'] -= 1;
    }

    // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
    for(int i : record){
        if(i < 0){
            return false;
        }
    }

    return true;
}

    public static void main(String[] args){
        String str1= "aa";
        String str2="aab";
        boolean res=new Q383().canConstruct(str1,str2);
        System.out.println(res);
    }
}
