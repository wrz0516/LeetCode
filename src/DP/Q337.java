package DP;

public class Q337 {

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
      }
    public int rob(TreeNode root) {
        int[] res= postOrder(root);
        return Math.max(res[0],res[1]);
    }
    public int[] postOrder(TreeNode node){
        int[] res = new int[2];
        if(node==null){
            return res;
        }

        int[] left=postOrder(node.left);
        int[] right=postOrder(node.right);
        //不偷当前节点，那么左右孩子都能偷
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //偷当前节点，左右孩子都不能偷
        res[1]=node.val+left[0]+right[0];
        return res;
    }
}
