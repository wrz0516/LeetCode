package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q17 {
    List<String> list = new ArrayList<>();
    StringBuilder res = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return list;
        String[] letter={"","","abc","def","ghi","jkl","mno",
        "pqrs","tuv","wxyz"};
        backtracing(digits,letter,0,digits.length());
        return list;
    }

    public void backtracing(String digits,String[] letter,int start,int k){
        if(res.length()==k){
                list.add(res.toString());
            return;
        }
        int index = digits.charAt(start)-'0'; //取得当前遍历的数字
        for(int i = 0;i<letter[index].length();i++){
            res.append(letter[index].charAt(i));
            backtracing(digits,letter,start+1,k);
            res.deleteCharAt(res.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits="";
        List<String> list = new Q17().letterCombinations(digits);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
