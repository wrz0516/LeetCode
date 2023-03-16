package Strings;

public class QJ05 {
    public String replaceSpace(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sum+=1;
            }
        }
        int len=s.length()-sum+sum*3;
        char[] str=new char[len];
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                str[index++]='%';
                str[index++]='2';
                str[index++]='0';
            }else{
                str[index++]=s.charAt(i);
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String s="We are happy.";
        String str=new QJ05().replaceSpace(s);
        System.out.println(str);
    }
}
