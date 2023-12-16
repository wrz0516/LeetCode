package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(),pLen=p.length();
        if(sLen<pLen) return ans;
        int[] sLetter = new int[26];
        int[] pLetter = new int[26];
        for(int i=0;i<pLen;i++){
            sLetter[s.charAt(i)-'a']++;
            pLetter[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sLetter,pLetter)){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            sLetter[s.charAt(i)-'a']--;
            sLetter[s.charAt(i+pLen)-'a']++;
            if(Arrays.equals(sLetter,pLetter)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
