package Stack;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] visited = new int[26];
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (visited[cur - 'a'] == 0) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > cur) {
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = 0;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else {
                        break;
                    }
                }
                visited[cur - 'a'] = 1;
                sb.append(cur);
            }
            nums[cur-'a']--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "edebbed";
        String res = new Q316().removeDuplicateLetters(s);
        System.out.println(res);
    }
}
