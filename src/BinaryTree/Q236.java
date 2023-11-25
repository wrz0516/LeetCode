package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class Q236 {
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
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        return getAncestor(root,p,q);
    }

    public TreeNode getAncestor(TreeNode node, int p, int q){
        if(node == null || node.val == p || node.val ==q){
            return node;
        };

        TreeNode left = getAncestor(node.left,p,q);
        TreeNode right = getAncestor(node.right,p,q);
        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return node;
        }
    }
    public static void main(String[] args) {
        Integer[] array = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = new Q236().constructTree(array);
        new Q236().lowestCommonAncestor(root,7,2);
    }
}
