package HashTable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Q1002 {
    public List<String> commonChars(String[] words) {
        int temp=(int)'a';
        List<String> letter=new ArrayList<>();
        int[][] hashTable=new int[words.length][26];
        for(int i=0;i< words.length;i++){ //第i个字符串
            for(int j=0;j<words[i].length();j++){ //第i个字符串的第j个字母
                hashTable[i][words[i].charAt(j)-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j< words.length;j++){
                if(hashTable[j][i]<min){
                    min=hashTable[j][i];
                }
            }
            if(min>0){
                for(int k=0;k<min;k++){
                    int cu=temp+i;
                    char ch=(char)cu;
                    letter.add(new String(new char[]{ch}));
                }
            }
        }
        return letter;
    }
    public static void main(String[] args){
        String[] words={"cool","lock","cook"};
        Q1002 demo=new Q1002();
        List<String> res=demo.commonChars(words);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
