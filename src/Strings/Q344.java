package Strings;

public class Q344 {
    public void reverseString(char[] s) {
//            int i=0;
//            while(i<s.length){
//                for(int j=0;j<s.length-i-1;j++) {
//                    char ch = s[j];
//                    s[j] = s[j + 1];
//                    s[j+1]=ch;
//                }
//                i++;
//            }
        for(int i=0;i<s.length/2;i++){
            char ch = s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=ch;
        }
    }

    public static void main(String[] args) {
        char[] s={'H','a','n','n','a','h'};
        new Q344().reverseString(s);
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
}
