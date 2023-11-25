package BinaryTree;

public class Q98 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean check(TreeNode node,long upper,long lower){
        if(node==null) {
            return true;
        }
        if(node.val>=upper||node.val<=lower) return false;

        boolean resLeft= check(node.left,node.val,lower);
        boolean resRight = check(node.right,upper, node.val);
        return resLeft&&resRight;
    }
    /*
    给每个节点都确定一个上界和下界
    对于根节点，上界和下界分别是无穷大和无穷小
    对于任意一个节点，他的左子节点的上界就是该节点的值，下界是该结点的下界；
    他的右子节点的下界就是该节点的值，上界是该节点的上界
     */
}
