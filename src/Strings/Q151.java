package Strings;

public class Q151 {
    public String reverseWords(String s) {
        int left=0;
        int right=0;
        s=s.trim();
        StringBuffer sb=new StringBuffer();
        String[] strs=s.split(" ");
        for(int i= strs.length-1;i>=0;i--){
            if(strs[i].equals("")){
                continue;
            }else{
                sb.append(strs[i]);
                if(i>0){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="  hello world  ";
        String res=new Q151().reverseWords(s);
        System.out.println(res);
    }
}
