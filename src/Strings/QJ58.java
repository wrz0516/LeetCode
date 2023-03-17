package Strings;

public class QJ58 {
    public String reverseLeftWords(String s, int n) {
        String str2=s.substring(0,n);
        String str1=s.substring(n);
        StringBuffer sb=new StringBuffer();
        sb.append(str1);
        sb.append(str2);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s= "lrloseumgh";
        int k = 6;
        String res = new QJ58().reverseLeftWords(s,k);
        System.out.println(res);
    }
}
