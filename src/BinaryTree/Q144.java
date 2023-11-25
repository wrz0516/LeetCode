package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Q144 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            preorder(root,res);
            return res;
        }

        public void preorder(TreeNode cur,List<Integer> list){
            if(cur==null){
                return;
            }
            list.add(cur.val);
            preorder(cur.left,list);
            preorder(cur.right,list);
        }
    }
    }
}
