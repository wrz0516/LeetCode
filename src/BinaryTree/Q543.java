package BinaryTree;

//import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Q543 {
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
    public TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        int index = 0;
        int length = array.length;
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
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

    public static void main(String[] args) {
        Integer[] array = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = new Q543().constructTree(array);

    }
}
