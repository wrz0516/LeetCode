package Strings;

public class Q459 {
    public boolean repeatedSubstringPattern(String s) {

        for(int i=0;i<s.length();i++) {
            String pattern = s.substring(0, i + 1);
            int j = i + 1;
            while (j < s.length()) {
                if (j <= s.length() - 1 && i + j >= s.length()) {
                    break;
                }
                String temp = s.substring(j, j + i + 1);
                if (temp.equals(pattern)) {
                    j = j + i + 1;
                    if (j >= s.length()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s= "aba";
        boolean res= new Q459().repeatedSubstringPattern(s);
        System.out.println(res);
    }
}
