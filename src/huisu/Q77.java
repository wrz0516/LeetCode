package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    List<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracing(n,1,k);
        return list;
    }

    public void backtracing(int n, int start, int k){
        if(temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n-(k-temp.size())+1;i++){ //剪枝优化
            temp.add(i);
            backtracing(n,i+1,k);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        new Q77().combine(4,2);
    }
}
