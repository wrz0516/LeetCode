package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        func(root);
        return result;
    }

    public void func(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int len = queue.size();
            while(len>0){
                TreeNode curNode = queue.poll();
                len--;
                arr.add(curNode.val);
                if(curNode.left !=null) queue.add(curNode.left);
                if(curNode.right !=null) queue.add(curNode.right);
            }
            result.add(arr);
        }
    }
}
