package erchashu;

import sun.reflect.generics.tree.Tree;

public class Q543 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxWidth = 0;
    public int getWidth(TreeNode node){
        if(node==null) return 0;
        int leftWidth = getWidth(node.left); //node节点左子树的最大深度（不包括根节点node）
        int rightWidth = getWidth(node.right); //node节点右子树的深度（不包括根节点node）
        maxWidth = Math.max(leftWidth+rightWidth,maxWidth); //左子树+右子树的深度即该结点的最大宽度
        return Math.max(leftWidth,rightWidth)+1; //返回该结点的最大深度
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getWidth(root);
        return maxWidth;
    }
}
