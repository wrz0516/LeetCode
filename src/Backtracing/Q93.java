package Backtracing;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    List<String> list = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    int len=0;
    public List<String> restoreIpAddresses(String s) {
        backtracing(s,0);
        return list;
    }
    public void backtracing(String s,int start){
        if(len==4&&start>=s.length()){
            list.add(new String(sb.substring(1)));
            return;
        }
        for(int i=start;i<s.length();i++){
            String sub = s.substring(start,i+1);
            if(len<4&&isQualified(sub)) {
                sb.append(".");
                sb.append(sub);
                len++;
                backtracing(s,i+1);
                sb=new StringBuffer(sb.substring(0,sb.length()-sub.length()-1));
                len--;
            }else{
                break;
            }
        }
    }

    public boolean isQualified(String s){
        if(s.charAt(0)=='0'&&s.length()>1) return false;
        if(Integer.valueOf(s)>255) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "101023";
        List<String> res = new ErShua.Q93().restoreIpAddresses(s);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
