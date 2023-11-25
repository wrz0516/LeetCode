package Backtracing;

import java.util.*;

public class Q131 {
    List<List<String>> list = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracing(s,0);
        return list;
    }

    public void backtracing(String s, int start){
        if(start>=s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            String cur = s.substring(start,i+1);
            if(isPalindrome(cur)){
                temp.add(cur);
            }else{
                continue;
            }
            backtracing(s,i+1);
            temp.removeLast();
        }
    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new Q131().partition(s);
        for (List<String> strings : res) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}
