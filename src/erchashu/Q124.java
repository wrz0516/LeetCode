package erchashu;
/*
二叉树中的最大路径之和
解题关键：得到每个节点的最大贡献值（最大贡献值指该结点为根节点）
 */
public class Q124 {

    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxValue;
    }

    public int getSum(TreeNode node){
        if(node == null) return 0;
        int resLeft = Math.max(getSum(node.left),0);
        int resRight = Math.max(getSum(node.right),0);

        int priceNewpath = node.val+resLeft+resRight;
        maxValue = Math.max(priceNewpath,maxValue);

        return node.val+Math.max(resLeft,resRight);


    }

    public static void main(String[] args) {
        Integer[] array = {-10,9,20,null,null,15,7};
        TreeNode root = new TreeNode().constructTree(array);
        int res = new Q124().maxPathSum(root);
        System.out.println(res);
    }
}
