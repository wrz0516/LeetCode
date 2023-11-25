package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
解题的关键是：找到每个节点的前趋节点
 */
public class Q114 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();

        if(root==null) return;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp);
            if(temp.right!=null) stack.add(temp.right);
            if(temp.left!=null) stack.add(temp.left);
        }
        for(int i = list.size()-1;i>0;i--){
            TreeNode cur = list.get(i);
            TreeNode pre = list.get(i-1);
            pre.left = null;
            pre.right = cur;
        }
    }
}
