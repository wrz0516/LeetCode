package erchashu;

import java.util.LinkedList;
import java.util.Queue;

public class Q101 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return compare(root.left, root.right);
    }
//    public boolean compare(TreeNode left, TreeNode right){
//        if(left == null && right!=null) return false;
//        else if(left != null && right == null) return false;
//        else if(left == null && right == null) return true;
//        else if(left.val != right.val) return false;
//
//        boolean out = compare(left.left,right.right);
//        boolean in = compare(left.right,right.left);
//        boolean res = out&&in;
//        return res;
//    }
    public boolean compare(TreeNode left, TreeNode right){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if(leftNode == null && rightNode == null) continue;
            else if(leftNode==null || rightNode==null ||leftNode.val!= rightNode.val){
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
