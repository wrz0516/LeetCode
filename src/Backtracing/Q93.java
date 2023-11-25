package Backtracing;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    List<String> list = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    int len =0;
    public List<String> restoreIpAddresses(String s) {
        backtracing(s,0);
        return list;

    }

    public void backtracing(String s,int start){
        if(len==4&start>=s.length()){
            String res = str.substring(0,str.length()-1);
            list.add(res);
            return;
        }
        for(int i=start;i<s.length();i++){
            String cur = s.substring(start,i+1);
            if(len<=3&&isQulified(cur)){
                str.append(cur);
                str.append(".");
                len++;
                backtracing(s,i+1);
                str = new StringBuilder(str.substring(0,str.length()-i+start-2));
                len--;
            }else{
                break;
            }
        }
    }

    public boolean isQulified(String temp){
        if(temp.charAt(0)=='0'&&temp.length()>1) return false;
        if(Integer.valueOf(temp)>255) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new Q93().restoreIpAddresses(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
