package BinaryTree;

import java.util.HashMap;
import java.util.Map;
/*
解题关键：
 */
public class Q105 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Map<Integer,Integer> map = new HashMap<>();
    public  TreeNode myBuildTree(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        if(inLeft>inRight) return null;
        int cur = preorder[preLeft]; //当前根节点的值
        TreeNode curRoot = new TreeNode(cur);
        int inIndex = map.get(cur);
        int newPreRight = inIndex-inLeft;
        curRoot.left = myBuildTree(preorder,inorder,preLeft+1,preLeft+newPreRight,inLeft,inIndex-1);
        curRoot.right = myBuildTree(preorder,inorder,preLeft+newPreRight+1,preRight,inIndex+1,inRight);
        return curRoot;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
        TreeNode node = myBuildTree(preorder,inorder,0,len-1,0,len-1);
        return node;
    }
}
