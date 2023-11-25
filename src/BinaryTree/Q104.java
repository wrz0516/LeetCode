package BinaryTree;

public class Q104 {
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

//    public int maxDepth(TreeNode root){
//        Queue<TreeNode> que = new LinkedList<>();
//        if(root==null) return 0;
//        que.offer(root);
//        int depth = 0;
//        while(!que.isEmpty()){
//            int len = que.size();
//            while (len>0){
//                TreeNode cur = que.poll();
//                len--;
//                if(cur.left!=null) que.offer(cur.left);
//                if(cur.right!=null) que.offer(cur.right);
//            }
//            depth+=1;
//        }
//        return depth;
//    }
    //递归方式求解
    public int getDepth(TreeNode node){
        if(node==null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        int maxDepth = 1+Math.max(leftDepth,rightDepth);
        return maxDepth;
    }
    public int maxDepth(TreeNode root){
        return getDepth(root);
    }
}
