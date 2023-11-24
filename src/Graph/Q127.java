package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[][] map = new int[1+wordList.size()][1+wordList.size()];
        int[] visited = new int[1+wordList.size()];
        if(!wordList.contains(endWord)) return 0;
        int cur=1;
        for (String s : wordList) {
            int temp=0;
            for(int i=0;i<beginWord.length();i++){
                if(beginWord.charAt(i)!=s.charAt(i)) temp++;
            }
            if(temp==1) {
                map[cur][0]=1;
                map[0][cur]=1;
            }
            cur++;
        }

        for(int i=0;i<wordList.size();i++){
            String curS = wordList.get(i);
            for(int j=i+1;j<wordList.size();j++){
                int temp=0;
                String tempS = wordList.get(j);
                for(int k=0;k<beginWord.length();k++){
                    if(curS.charAt(k)!=tempS.charAt(k)) temp++;
                }
                if(temp==1) {
                    map[i+1][j+1]=1;
                    map[j+1][i+1]=1;
                }
            }
        }
        int res = bfs(endWord,wordList,map,visited);
        return res;
    }

    public int bfs(String endWord, List<String> wordList,int[][] map,int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0]=1;
        int num=1;
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len>0){
                int cur = queue.poll();
                len--;
                for(int i=0;i<map.length;i++){
                    if(visited[i]==0&&map[cur][i]==1) {
                        if(wordList.get(i-1).equals(endWord)) return num+1;
                        queue.offer(i);
                        visited[i]=1;
                    }
                }
            }
            num++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] strs={"hot","dog"};
        List<String> wordList = Arrays.asList(strs);
        int res = new Q127().ladderLength(beginWord,endWord,wordList);
        System.out.println(res);
    }
}
