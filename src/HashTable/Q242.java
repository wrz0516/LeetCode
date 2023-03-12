package HashTable;
import java.util.Scanner;
public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] tableS=new int[26];
        int[] tableT=new int[26];

        for(int i=0;i<s.length();i++){
            tableS[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            tableT[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(tableS[i]!=tableT[i]){
                return false;
            }
        }
        return true;
    }
    //官方解法
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            table[t.charAt(i) - 'a']--;
//            if (table[t.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args){
        String s="anagram";
        String t="nagaram";
        Q242 demo=new Q242();
        boolean res=demo.isAnagram(s,t);
        System.out.println(res);
    }
}
